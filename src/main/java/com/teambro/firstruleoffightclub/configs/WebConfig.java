package com.teambro.firstruleoffightclub.configs;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * Created by zac on 1/23/17.
 */
@Configuration
public class WebConfig {
    @Bean
    public Jedis Jedis(){
        return new Jedis("localhost");
    }
}
