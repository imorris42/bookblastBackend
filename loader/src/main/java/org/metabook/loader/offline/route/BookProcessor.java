package org.metabook.loader.offline.route;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.TypeConverter;
import org.apache.camel.component.file.GenericFile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.CellRangeAddressList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.util.CTColComparator;
import org.metabook.repository.book.Book;
import org.metabook.repository.book.BookContributor;
import org.metabook.repository.book.BookRepository;
import org.metabook.repository.book.Category;
import org.metabook.repository.book.ContentType;
import org.metabook.repository.book.Contributor;
import org.metabook.repository.book.ContributorRepository;
import org.metabook.repository.book.FileFormat;
import org.metabook.repository.book.Media;
import org.metabook.repository.book.MediaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class BookProcessor implements Processor{


    private final static Log log = LogFactory.getLog(BookProcessor.class);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final static int NUMBER_OF_CONTRIBUTORS = 4;
    private final static int NUMBER_OF_ROWS = 331;//80;
    private final static int START_ROW = 38;
    
/*    @Autowired
    private TypeConverter typeConverter;
    */
    
    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public ContributorRepository contributorRepository;
    
    
    private String deNormalisedName;	
	@Override
	public void process(Exchange exchange) throws Exception {
    	System.out.println("excel book processor");
    	GenericFile body = ((GenericFile) exchange.getIn().getBody());
    	File aFile = ((File) body.getFile());
    	List<Book> offlineBooks = new ArrayList<Book>();
    	List<Book> failedBooks = new ArrayList<Book>();
   	
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(aFile);
            XSSFSheet sheet = workbook.getSheetAt(1);

            for (Iterator rit = sheet.rowIterator(); rit.hasNext();) {
                XSSFRow row = (XSSFRow) rit.next();
                if (row.getRowNum() <= START_ROW) { //skip first two rows
                	continue;
                   //monthlyExtract.date = dateFormat.parse(row.getCell(11).getStringCellValue());
                }
                if(row.getRowNum()  <= START_ROW + NUMBER_OF_ROWS) {
                   	Book book = new Book();
                	try {
                 
                    XSSFCell isbn13Cell = row.getCell(1);
                    XSSFCell isbn10Cell = row.getCell(0);
                    String isbn13 = null;
                    if (isbn13Cell != null && isbn13Cell.getCellType() == isbn13Cell.CELL_TYPE_NUMERIC && !StringUtils.isEmpty(isbn13Cell.getNumericCellValue())) {
                    	isbn13 = new Integer((new Double(isbn13Cell.getNumericCellValue()).intValue())).toString();
                    }
                    else if (isbn13Cell != null && isbn13Cell.getCellType() == isbn13Cell.CELL_TYPE_STRING && !StringUtils.isEmpty(isbn13Cell.getStringCellValue())) {
                    	isbn13 =isbn13Cell.getStringCellValue();
                    }
                    else isbn13 = "NONE";
                    if (null != isbn13){

                    	java.util.List<BookContributor> bookContributors = new ArrayList<BookContributor>();
                    	XSSFCell leadingArticleCell = row.getCell(2);
                    	XSSFCell mainTitleCell = row.getCell(3);
                    	XSSFCell subTitleCell = row.getCell(4);
                    	XSSFCell seriesTitleCell = row.getCell(5);
                    	XSSFCell seriesVolumeNumberCell = row.getCell(6);
                    	XSSFCell productFormatCell = row.getCell(7);
                    	XSSFCell productFormatDetailCell = row.getCell(8); 
                    	XSSFCell numberOfPagesCell = row.getCell(9);
                    	XSSFCell placeOfPublicationCell = row.getCell(10);
                    	XSSFCell countryOfPublicationCell = row.getCell(11);
                    	XSSFCell printedInCell = row.getCell(12);
                    	for(int i=0; i < NUMBER_OF_CONTRIBUTORS; i++) {
                        	addContributor(13 + (i*3), row, book, bookContributors);
						}

                    	XSSFCell publisherNameCell = row.getCell(27);     
                    	XSSFCell imprintCell = row.getCell(28);  
                    	XSSFCell languageCell = row.getCell(29); 

                    	XSSFCell briefDescriptionCell = row.getCell(30);     
                    	XSSFCell fullDescriptionCell = row.getCell(31);  
                    	XSSFCell categoryCell = row.getCell(32);
                    	if(categoryCell != null && !StringUtils.isEmpty(categoryCell.getStringCellValue())){
                    	String categories = categoryCell.getStringCellValue();
                    	addCategory(categories, book);
                    	}
                    	XSSFCell authorWebsiteCell = row.getCell(33);  
                    	XSSFCell publisherWebsiteCell = row.getCell(34);
                    	XSSFCell additionalWebsiteCell = row.getCell(35);
                    	XSSFCell publicationDateCell = row.getCell(36);
                    	
                    	if (null!= leadingArticleCell) book.setLeadingArticle(leadingArticleCell.getStringCellValue());
                    	if (null!= mainTitleCell) book.setMainTitle(mainTitleCell.getStringCellValue());
                    	if (null!= subTitleCell && ( subTitleCell.getCellType()==subTitleCell.CELL_TYPE_STRING)) book.setSubTitle(subTitleCell.getStringCellValue());
                    	if (null!= seriesTitleCell) book.setSeriesTitle(seriesTitleCell.getStringCellValue());
                    	if (null!= seriesVolumeNumberCell && !(seriesVolumeNumberCell.getCellType()==seriesVolumeNumberCell.CELL_TYPE_STRING)) book.setSeriesVolumeNumber( new Integer((new Double(seriesVolumeNumberCell.getNumericCellValue()).intValue())).toString());
                    	if (null!= productFormatCell) book.setProductFormatCode(productFormatCell.getStringCellValue());
                    	if (null!= productFormatDetailCell) book.setProductFormatText(productFormatDetailCell.getStringCellValue());
                        if (null!= numberOfPagesCell  && !(numberOfPagesCell.getCellType()==numberOfPagesCell.CELL_TYPE_STRING)) book.setPaginationNumeric(new Integer(new Double(numberOfPagesCell.getNumericCellValue()).intValue()).toString());
                        if (null!= placeOfPublicationCell) book.setPlaceOfPublication(placeOfPublicationCell.getStringCellValue());
                        if (null!= countryOfPublicationCell)  book.setCountryOfPublication(countryOfPublicationCell.getStringCellValue());
                        book.setIsbn13(isbn13);
                  
                        if (null!= printedInCell) book.setPrintedIn(printedInCell.getStringCellValue());
                        
                        if (null!= publisherNameCell) book.setPublisherName(publisherNameCell.getStringCellValue());
                        if (null!= imprintCell) book.setImprint(imprintCell.getStringCellValue());
                        if (null!= languageCell) book.setLanguageCode(languageCell.getStringCellValue());
                        if (null!= briefDescriptionCell) {
                        	//briefDescriptionCell.getStringCellValue())
                        	book.setBriefDescription(briefDescriptionCell.getStringCellValue());
                        }
                        if (null!= fullDescriptionCell) { 
                        	String bookFullDescription = fullDescriptionCell.getStringCellValue(); 
                        	int fdLength = bookFullDescription.length();
                        	if (fdLength > 1000) bookFullDescription.substring(0, 1000);
                        	book.setFullDescription(bookFullDescription);
                        }
                                              
                        if (null!= authorWebsiteCell) book.setAuthorWebsite(authorWebsiteCell.getStringCellValue());
                        if (null!= additionalWebsiteCell) book.setAdditionalWebsite(additionalWebsiteCell.getStringCellValue());
                        if (null!= publisherWebsiteCell) book.setPublisherWebsite(publisherWebsiteCell.getStringCellValue());
                        if (null!= publicationDateCell   && !(publicationDateCell.getCellType()==numberOfPagesCell.CELL_TYPE_STRING)) book.setPublicationDate(new Integer(new Double(publicationDateCell.getNumericCellValue()).intValue()).toString());
                        if (bookContributors.size() > 0 ) book.setBookContributors(bookContributors);
                        offlineBooks.add(book);
                            }
                	}
                	 catch (IllegalStateException ise){
                       	 log.error("Format error Excel on " +  book.getIsbn13() + " exception " +  ise);
                       	 failedBooks.add(book);
                       	 //throw new RuntimeException("Unable to import Excel", ise);
                }
               	 catch (Exception ex){
                   	 log.error("Format error Excel on " +  book.getIsbn13() + " exception " +  ex);
                   	 failedBooks.add(book);
                   	 //throw new RuntimeException("Unable to import Excel", ise);
            }
                	
                    }
                else break;
            }
            }
            catch (Exception e) {
            log.error("Unable to import Excel", e);
            throw new RuntimeException("Unable to import Excel", e);
        }
        finally{
            try {
            	log.info("Finished import of books, added : " + offlineBooks.size() + " ,errors :" + failedBooks.size());
            	for (Iterator iterator = failedBooks.iterator(); iterator
						.hasNext();) {
					Book failedBook = (Book) iterator.next();
					if (null != failedBook.getMainTitle()) log.info("Failed book: " + failedBook.getMainTitle());
					else log.info("Failed book: No title ");
				}
                workbook.close();
            } catch (IOException e) {
                log.error("Unable to close Excel", e);
            }
        }
        exchange.getIn().setBody(offlineBooks);
        //return offlineBooks;
    }
    
    private List<Media> lookUpAnyImagesForThisBook(String isbn13, String title, XSSFWorkbook workbook) {
    	Map<String, List<Media>> allImageWithISBNReference = new HashMap<String, List<Media>>();
    	Map<String, List<Media>> allImageWithTitleReference = new HashMap<String, List<Media>>();
    	   
    	 XSSFSheet imageSheet = workbook.getSheetAt(2);
    	 CellRangeAddress allImagesArea = new CellRangeAddress(1,80, 0, 3);
         //List matches<Integer>() = findRow(imageSheet, 0, isbn13, title) ;      
         for (Iterator rit = imageSheet.rowIterator(); rit.hasNext();) {
             XSSFRow row = (XSSFRow) rit.next();
             if (row.getRowNum() <= START_ROW) { //skip first two rows
             	continue;
             }
             if(row.getRowNum()  <= START_ROW + NUMBER_OF_ROWS) {
                	
             	try {
                	XSSFCell codeCell = row.getCell(0);
                	XSSFCell contentTypeCell = row.getCell(1);
                	//XSSFCell modeCell = row.getCell(2);
                	XSSFCell filenameCell = row.getCell(3);
                	XSSFCell fileFormatCell = row.getCell(4);
                	Media thisMedia = new Media();
                	if (null!= filenameCell) {
                		String fileName = filenameCell.getStringCellValue();
                		thisMedia.setUri(fileName);
                	}
                	if (null!= contentTypeCell) {
                		String contentType = contentTypeCell.getStringCellValue();
                		ContentType ct = ContentType.valueOf(contentType);
                    	if (null!= contentTypeCell) thisMedia.setContentType(ct);
                	}
                	if (null!= fileFormatCell) {
                		String fileFormat = fileFormatCell.getStringCellValue();
                		FileFormat fmt = FileFormat.valueOf(fileFormat);
                    	if (null!= fileFormatCell) thisMedia.setFileFormat(fmt);
                	}
                	
                	thisMedia.setMediaType(MediaType.Image);
                	String code = new String();
                	if (null!= codeCell) {
                		code = codeCell.getStringCellValue();
                		code = code.trim();
                		
                		if (code.startsWith("9")){
            
                		}
                	}
             	
                 	Media eachMedia = new Media();
                 	//eachMedia.se
             	}
             	catch (Exception e) {
             	System.out.println(e);	
             	}
             	}
             }
             
       
        CTCol codeColumn = imageSheet.getColumnHelper().getColumn(0, false);
    	
    	return null;
    	
    }
    private Integer[] findRow(HSSFSheet sheet, int indexColumn, String isbn, String title) {
    	List<Integer> matches = new ArrayList<Integer>();
        for (Row row : sheet) {
        	Cell cell =row.getCell(indexColumn);
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(isbn)) {
                        matches.add(row.getRowNum());
                    }
                    else if (cell.getRichStringCellValue().getString().trim().equals(title)) {
                        matches.add(row.getRowNum());
                    }
                }
            }
                       
        return (Integer[]) matches.toArray();
    }
    
    public void addContributor(int startCell, XSSFRow row, Book book, List<BookContributor> bookContributors) {
    	XSSFCell contributorRoleCell = row.getCell(startCell);
    	
    	XSSFCell contriibutorFirstNameCell = row.getCell(startCell + 1);
    	XSSFCell contriibutorLastNameCell = row.getCell(startCell + 2);
    	if(contributorRoleCell != null && !StringUtils.isEmpty(contributorRoleCell.getStringCellValue())){
    	 if (contriibutorLastNameCell != null && !StringUtils.isEmpty(contriibutorLastNameCell.getStringCellValue())){
    		    String lastName = contriibutorLastNameCell.getStringCellValue();
    		    String firstName = "";
    		    if (contriibutorFirstNameCell != null && !StringUtils.isEmpty(contriibutorFirstNameCell.getStringCellValue())){
    		    	firstName = contriibutorFirstNameCell.getStringCellValue();
    		    }
    		    Contributor contributor = null;
    		   /* String lookupName = denormaliseName(firstName, lastName);
    		    List<Contributor> lookupContributor = contributorRepository.findContributorByDenormalisedName(lookupName);
    		    if (lookupContributor.size()==1) {
    		    	contributor=lookupContributor.get(0);
    		    }*/
    		    //if (contributor == null)  
    		    contributor = new Contributor(firstName, lastName);
    			BookContributor bookContributor = new BookContributor(book, contributor, (contributorRoleCell.getStringCellValue()));
    			//bookContributor.setRole(contributorRoleCell.getStringCellValue());
    			bookContributors.add(bookContributor);
    		 }
    	}
    }
    
    public void addCategory(String categories, Book book) {

    	if(categories != null && !StringUtils.isEmpty(categories)){
    		List<Category> categoriesToAdd = new ArrayList<Category>();
    		String[] categoryArray = StringUtils.commaDelimitedListToStringArray(categories);
    		for (int i = 0; i < categoryArray.length; i++) {
				Category category = new Category();
				category.setDeNormalisedTitle(categoryArray[i].toLowerCase());
				category.setCategoryTitle(categoryArray[i]);
				categoriesToAdd.add(category);
			}
        	book.setCategories(categoriesToAdd);    		
    	}

    }
    
	public String denormaliseName(String firstName, String lastName) {
		if (StringUtils.isEmpty(firstName)) {
				firstName = "";
		}
		if (!StringUtils.isEmpty(lastName)){
		firstName = StringUtils.trimAllWhitespace(firstName);
		lastName = StringUtils.trimAllWhitespace(lastName);
		deNormalisedName = firstName + lastName;
		deNormalisedName = StringUtils.capitalize(deNormalisedName);
	}
		return deNormalisedName;
	}
}