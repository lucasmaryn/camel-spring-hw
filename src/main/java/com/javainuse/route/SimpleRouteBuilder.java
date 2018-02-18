package com.javainuse.route;

import com.javainuse.MyProcessor;
import com.javainuse.exception.CamelCustomException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        onException(CamelCustomException.class).process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println("Handling exception");
            }
        }).redeliveryPolicyRef("testRedeliveryPolicyProfile").log("Received body ${body}").handled(true);

        from("file:C:/camel-InputFolder?noop=true").process(new MyProcessor()).to("file:C:/camel-OutputFolder");
    }
}
