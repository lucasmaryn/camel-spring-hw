package com.javainuse.route;

import com.javainuse.exception.CamelCustomException;
import com.javainuse.MyProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("file:C:/camel-InputFolder?noop=true")
                .doTry().process(new MyProcessor()).to("file:C:/camel-OutputFolder")
                .doCatch(CamelCustomException.class).process(new Processor() {

                    public void process(Exchange exchange) throws Exception {
                        System.out.println("handling exception");
                    }
                }).log("Recived body ${body}");

        from("file:C:/camel-InputFolder?noop=true").process(new MyProcessor()).to("file:C:/camel-OutputFolder");
    }
}
