package ru.leshuk.springvueexp.security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;

@Service
@AllArgsConstructor
public class JwtService {
    //todo: настройка "констант" через проперти?
    private static final long EXPIRATION_TIME = 86400000; //1 день в миллисекундах
    public static final String PREFIX = "Bearer ";
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String getToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String getAuthUser(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null) {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();
        }
        return null;
    }
}
