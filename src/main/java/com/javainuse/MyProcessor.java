package com.javainuse;

import com.javainuse.exception.CamelCustomException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        System.out.println("Exception thrown");
        throw new CamelCustomException();
    }
}
