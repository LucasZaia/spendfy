package com.spendfy.api.enums.security.service;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.spendfy.api.enums.security.User.UserSec;
import com.spendfy.api.utils.GetDateTime;

@Service
public class JwtTokenService {

    private static final String SECRET = "9t337nNJGbNDLt2HPUGRLXtbVN6KOHHq";

    private static final String ISSUER = "pizzurg-api";

    private static GetDateTime getDateTime = GetDateTime.getInstance();

    public String generateToken(UserSec userSec){
        try {
           Algorithm algorithm = Algorithm.HMAC256(SECRET); 
        
           return JWT.create()
            .withIssuer(ISSUER)
            .withIssuedAt(getDateTime.creationDateTime())
            .withExpiresAt(getDateTime.expirationDateTime())
            .withSubject(userSec.getUsername())
            .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new JWTCreationException("Error to generate token", exception);
        }
    }

    public String getSubjectFromToken(String token){

        try {

            Algorithm algorithm = Algorithm.HMAC256(SECRET);

            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
            throw new JWTVerificationException("This token is invalid or expired.", exception);
        }
    }
    
}
