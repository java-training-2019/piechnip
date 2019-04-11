package com.luxoft.ak47;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class TradeEventController {

    @RequestMapping(value = "/tradeEvent/{id}", produces = MediaType.TEXT_XML_VALUE)
    String tradeEvent(@PathVariable String id) {
        List<String> currency = Arrays.asList("PLN", "USD", "GBP");
        Random los = new Random();
        String currStr = currency.get(los.nextInt(currency.size()));
        String tradeLocationTag;

        if (id.startsWith("OBS")) {
            tradeLocationTag = "<tradeLocation>HKG</tradeLocation>";
        } else {
            tradeLocationTag = "";
        }
        return "<tradeEvent><id>" + id + "</id><version>0</version>" +
                "<currency>" + currStr + "</currency>" +
                tradeLocationTag + "</tradeEvent>";


    }
}
