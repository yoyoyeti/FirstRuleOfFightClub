package com.teambro.firstruleoffightclub.repositories;

/**
 * Created by zac on 1/21/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Repository
public class DictionaryRepository {
    private final Jedis jedis;
    private static final int HIGHESTADJECTIVE = 15734;
    private static final int HIGHESTNOUN = 69471;

    @Autowired
    public DictionaryRepository(Jedis jedis) {
        this.jedis = jedis;
        if(jedis.get("0") == null || jedis.get(Integer.toString(HIGHESTADJECTIVE + 1)) == null){
            initialize("/dictionaries/conv.data.adj", 0);
            initialize("/dictionaries/conv.data.noun", HIGHESTADJECTIVE + 1);
        }
    }

    private void initialize(String fileName, int startingPoint){

        BufferedReader br;
        String currentLine;
        int i = startingPoint;

        try {
            ClassPathResource classPathResource = new ClassPathResource(fileName);
            InputStream is = classPathResource.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((currentLine = br.readLine()) != null) {
                jedis.set(Long.toString(i), currentLine);
                System.out.println(jedis.get(Long.toString(i)));
                i++;
            }
        }
        catch (IOException e){}

        System.out.println(Integer.toString(i));
    }

    public String getRecord(int recordNumber){
        return jedis.get(Integer.toString(recordNumber));
    }

    public void deleteRecord(String key){
        jedis.del(key);
    }
    public int getHighestAdjective(){
        return HIGHESTADJECTIVE;
    }
    public int getHighestNoun(){
        return HIGHESTNOUN;
    }
}