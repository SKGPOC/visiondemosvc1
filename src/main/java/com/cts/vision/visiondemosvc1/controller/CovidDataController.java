package com.cts.vision.visiondemosvc1.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class CovidDataController {

    @Autowired
    private CamelContext camelContext;
    @Autowired
    private ProducerTemplate producer;

    @GetMapping(value = "/covid", produces = MediaType.APPLICATION_XML_VALUE)
    public void getCovidData() {
        try {
            String value = producer.requestBody("direct:RouteToFetchCovidData", "", String.class);
        } catch (CamelExecutionException ex) {
            ex.printStackTrace();
        }

    }

}
