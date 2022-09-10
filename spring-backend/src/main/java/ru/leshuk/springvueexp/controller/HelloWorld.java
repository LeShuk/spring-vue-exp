package ru.leshuk.springvueexp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/hello")
public class HelloWorld {
    @GetMapping
    public String getRandomString() {
        final int startCharCode = 48; //код символа '0'
        final int endCharCode = 122; //код символа 'z'
        Random random = new Random();
        final int strLength = Math.abs(random.nextInt() % 256);

        return random.ints(startCharCode, endCharCode)
                        .limit(strLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
    }
    @GetMapping("/user")
    public String getAuthString(){
        return "Привет! Круто, что представился!";
    }
}
