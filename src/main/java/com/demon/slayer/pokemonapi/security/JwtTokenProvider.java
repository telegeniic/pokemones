package com.demon.slayer.pokemonapi.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
    
    private String jwtSecret = "askljdfgbaksjddbvbkjasdhvbkas";

    private int jwtExppirationInMs = 5000000;

    Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime()+jwtExppirationInMs);
        logger.warn("Se esta creando el token");

        String token = Jwts.builder()
                        .setSubject(username)
                        .setIssuedAt(currentDate)
                        .setExpiration(expirationDate)
                        .signWith(SignatureAlgorithm.HS512, jwtSecret)
                        .compact();
        return token;
    }

    public String getUsernameFromJWT(String token){
        Claims claims = Jwts.parser()
                        .setSigningKey(jwtSecret)
                        .parseClaimsJws(token)
                        .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
