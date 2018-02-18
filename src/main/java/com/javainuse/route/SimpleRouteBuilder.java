package com.javainuse.route;

import com.javainuse.MyProcessor;
import com.javainuse.exception.CamelCustomException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        /*
//        exception handling only for one route
        from("file:C:/camel-InputFolder?noop=true")
                .doTry().process(new MyProcessor()).to("file:C:/camel-OutputFolder")
                .doCatch(CamelCustomException.class).process(new Processor() {

                    public void process(Exchange exchange) throws Exception {
                        System.out.println("handling exception");
                    }
                }).log("Recived body ${body}");
        */

//        exception handling for all routes
        onException(CamelCustomException.class).process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println("Second handling exception");
            }
        }).log("Received body ${body}").handled(true);



        from("file:C:/camel-InputFolder?noop=true").process(new MyProcessor()).to("file:C:/camel-OutputFolder");
        from("file:C:/camel-InputFolder0?noop=true").process(new MyProcessor()).to("file:C:/camel-OutputFolder0");
    }
}
