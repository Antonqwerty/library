package com.antonqwerty.library.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TokenController {

    //spring profile к изучению

    @Value("${jwt.secret}")
    private String secret;

    @GetMapping
    public Map<String, String> getUserName(@RequestParam String name) {
        String token = Jwts.builder()
                .setSubject(name)
                .setExpiration(Date.from(LocalDate.now().plusDays(3).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return Map.of("token", token);
    }

}
