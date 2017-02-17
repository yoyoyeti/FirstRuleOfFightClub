package com.teambro.firstruleoffightclub.services;

import com.teambro.firstruleoffightclub.repositories.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zac on 2/3/17.
 */
@Service
public class AnalyticsService {
    private final URLRepository urlRepository;

    @Autowired
    public AnalyticsService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public int getClicks(String customURL){
        return urlRepository.findByCustomURL(customURL).getClicks();
    }
}
