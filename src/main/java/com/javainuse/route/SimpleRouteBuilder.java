package com.javainuse.route;

import com.javainuse.processor.MyProcessor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder{
    public void configure() throws Exception {
        from("file:C:/camel-InputFolder?noop=true").process(new MyProcessor()).to("file:C:/camel-OutputFolder");
    }
}
