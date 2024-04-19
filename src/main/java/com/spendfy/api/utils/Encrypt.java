package com.spendfy.api.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Encrypt {


    private static Encrypt instance;

    private String passString;

    private Encrypt (String _paString){
        this.passString = _paString;
    }

    public static Encrypt getInstance (String pwdString){

        if(instance == null){
            instance =  new Encrypt(pwdString);
        }
        
        return instance;
    }

    public String encryptString(){
        this.passString = BCrypt.withDefaults().hashToString(12, this.passString.toCharArray());
        return this.passString;
    }

}
