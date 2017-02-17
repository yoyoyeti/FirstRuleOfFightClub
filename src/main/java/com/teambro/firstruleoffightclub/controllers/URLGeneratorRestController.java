package com.teambro.firstruleoffightclub.controllers;

import com.teambro.firstruleoffightclub.models.PostURL;
import com.teambro.firstruleoffightclub.services.DictionaryService;
import com.teambro.firstruleoffightclub.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zac on 1/23/17.
 */
@RestController
@RequestMapping("/generate")
public class URLGeneratorRestController {

    private final DictionaryService dictionaryService;
    private final URLService urlService;

    @Autowired
    public URLGeneratorRestController(DictionaryService dictionaryService, URLService urlService) {
        this.dictionaryService = dictionaryService;
        this.urlService = urlService;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    String SetCustomURL(@RequestBody PostURL redirectURL) {

        String generatedURL = dictionaryService.generateURL(3 /* @TODO make this parameter driven*/);
        if(urlService.createURLRecord(generatedURL, redirectURL.oldURL))
            return generatedURL;
        else
            return "invalid";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    String GetCustomURL() {
        return dictionaryService.generateURL(1 /* @TODO make this parameter driven*/);
    }
}
