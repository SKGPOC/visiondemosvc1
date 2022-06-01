package com.cts.vision.visiondemosvc1.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CovidDataFetchRoute extends RouteBuilder {

    @Value("${vision.app.data.covidURL}")
    private String urlForData;

    @Override
    public void configure() throws Exception {
        // TODO Auto-generated method stub
        from("direct:RouteToFetchCovidData").routeId("id_CovidDataFetchRoute")
                .log(LoggingLevel.INFO, log, "Going to call api endpoint....")
                .to("https://" + urlForData+"?proxyAuthHost=ouparray.oup.com&proxyAuthPort=8080")
                .log(LoggingLevel.INFO, log, "${body}");

    }

}
