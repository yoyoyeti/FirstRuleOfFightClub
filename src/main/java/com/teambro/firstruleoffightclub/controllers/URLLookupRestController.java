package com.teambro.firstruleoffightclub.controllers;

import com.teambro.firstruleoffightclub.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zac on 1/18/17.
 */
@RestController
@RequestMapping("/{customURL}")
public class URLLookupRestController {

    private final URLService urlService;

    @Autowired
    public URLLookupRestController(URLService urlService) {
        this.urlService = urlService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView GetCustomURL(@PathVariable String customURL) {
        return new ModelAndView("redirect:" + urlService.getRedirectURL(customURL));
    }

}

