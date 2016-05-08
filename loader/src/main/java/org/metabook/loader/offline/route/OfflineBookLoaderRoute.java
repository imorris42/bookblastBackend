package org.metabook.loader.offline.route;

import java.io.InputStream;
import java.util.List;

import org.apache.camel.TypeConverter;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfflineBookLoaderRoute extends RouteBuilder {
 	//log("body is {$body}").
	
/*    @Autowired
    private TypeConverter typeConverter;
    */
	@Autowired	
	BookProcessor bookProcessor;
    @SuppressWarnings("deprecation")
	@Override
    public void configure() throws Exception {
        from("file:///tmp/etl/metabook/offline/in/").      
        doTry().
    	to("bean:bookProcessor").
    	split().
    	body().
	    to("jpa://org.metabook.repository.book.Book?usePersist=false").endDoTry().
        doCatch(IllegalStateException.class).
    	log("exception  is {$exceptionMessage}").handled(true).
    	doCatch(Exception.class).log("WATCH Unknown exception thrown  {$exceptionMessage} ").handled(true).
    	stop().
    	end();
    }
    /*
    doTry().
	convertBodyTo(InputStream.class).
	convertBodyTo(List.class).
	split().body().
    to("jpa://org.metabook.repository.book.Book?usePersist=false").endDoTry().
    doCatch(IllegalStateException.class).
	log("exception  is {$exceptionMessage}").handled(true).
	doCatch(Exception.class).log("WATCH Unknown exception thrown  {$exceptionMessage} ").handled(true).
	stop().
	end();
	*/ 
}
