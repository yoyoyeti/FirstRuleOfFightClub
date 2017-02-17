package com.teambro.firstruleoffightclub.repositories;

import com.teambro.firstruleoffightclub.models.CustomURL;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by zac on 1/23/17.
 */
@Repository
public interface URLRepository extends MongoRepository<CustomURL, String>{

    public CustomURL findByCustomURL(String customURL);

}
