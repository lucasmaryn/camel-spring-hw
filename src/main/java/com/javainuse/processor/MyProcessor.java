package com.javainuse.processor;

import com.javainuse.exception.CamelCustomException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {

        String a = exchange.getIn().getBody(String.class);
        System.out.println("Hello " + a);
        if (a.equalsIgnoreCase("test") ) {
            throw new CamelCustomException();
        }
    }
}
