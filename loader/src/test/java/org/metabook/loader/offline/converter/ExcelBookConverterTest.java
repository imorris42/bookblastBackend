package org.metabook.loader.offline.converter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.camel.builder.ExchangeBuilder;
import org.apache.camel.component.file.GenericFile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.metabook.loader.offline.route.BookProcessor;
import org.metabook.repository.book.Book;

@RunWith(BlockJUnit4ClassRunner.class)
public class ExcelBookConverterTest   {

      @Test
     public void testExcelConversion() {
            InputStream in = ExcelBookConverterTest.class.getClassLoader().getResourceAsStream("Book_4.xlsx");
            Assert.assertNotNull(in);
            InputStreamReader isr = new InputStreamReader(in);
            BookProcessor processor = new BookProcessor();
            
           // GenericFile gFile = new GenericFile();
            	//	gFile.setCopyFromAbsoluteFilePath(ExcelBookConverterTest.class.getClassLoader().getResource("Book_4.xls").getPath());
            		
           //processor.process(new ExchangeBuilder(null).build());
           //.assertNotNull(offlineBooks);
            //Assert.assertFalse(monthlyExtract.transactions.isEmpty());
        }
   
}
