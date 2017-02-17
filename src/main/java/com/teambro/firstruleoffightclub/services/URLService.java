package com.teambro.firstruleoffightclub.services;

import com.teambro.firstruleoffightclub.models.CustomURL;
import com.teambro.firstruleoffightclub.repositories.URLRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by zac on 1/23/17.
 */
@Service
public class URLService {
    private final URLRepository urlRepository;

    @Autowired
    public URLService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public boolean createURLRecord(String generatedURL, String redirectURL){
        if(!(redirectURL.contains("http://") || redirectURL.contains("https://"))){
            redirectURL = "http://" + redirectURL;
        }

        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);

        if(urlValidator.isValid(redirectURL)){
            urlRepository.save(new CustomURL(generatedURL, redirectURL));
            return true;
        }
        else return false;
    }

    public String getRedirectURL(String customURL){
        CustomURL url = urlRepository.findByCustomURL(customURL);
        url.setClicks(url.getClicks() + 1);
        urlRepository.save(url);

        return url.getRedirectURL();
    }

    public void deleteAll(){
        urlRepository.deleteAll();
    }
}

