package com.luxoft.ak47;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeEventController {

    @RequestMapping(name = "/tradeEvent", produces = MediaType.TEXT_XML_VALUE)
    String tradeEvent() {
        return "<tradeEvent><version>0</version></tradeEvent>";
    }
}
