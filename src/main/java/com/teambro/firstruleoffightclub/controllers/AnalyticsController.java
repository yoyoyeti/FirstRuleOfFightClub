package com.teambro.firstruleoffightclub.controllers;

import com.teambro.firstruleoffightclub.models.PostURL;
import com.teambro.firstruleoffightclub.services.AnalyticsService;
import com.teambro.firstruleoffightclub.services.DictionaryService;
import com.teambro.firstruleoffightclub.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zac on 2/3/17.
 */
@RestController
@RequestMapping("/{customURL}/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @Autowired
    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public int GetCustomURL(@PathVariable String customURL) {
        return analyticsService.getClicks(customURL);
    }
}
