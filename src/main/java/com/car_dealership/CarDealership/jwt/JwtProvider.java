package com.car_dealership.CarDealership.jwt;

import com.car_dealership.CarDealership.models.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtProvider {
    @Value("${jwt.token.secret}")
    private String secretWord;
    @Value("${jwt.token.expired}")
    private long validityTime;

    public String createToken(String email, List<Role> roles) {
        Claims claims = Jwts.claims().setSubject(email);

        Date currentTime = new Date();
        Date validity = new Date(currentTime.getTime() + validityTime);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(currentTime)
                .setExpiration(validity)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignInKey() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return key;
    }
}
