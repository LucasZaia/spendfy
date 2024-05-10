package com.spendfy.api.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class GetDateTime {

    private static GetDateTime instance;

    public static GetDateTime getInstance() {
        if (instance == null){
            instance = new GetDateTime();
        }

        return instance;
    }

    public Instant creationDateTime(){
        return ZonedDateTime.now(ZoneId.of("America/São Paulo")).toInstant();
    }

    public Instant expirationDateTime(){
        return ZonedDateTime.now(ZoneId.of("America/São Paulo")).plusHours(4).toInstant();
    }


    
    
}
