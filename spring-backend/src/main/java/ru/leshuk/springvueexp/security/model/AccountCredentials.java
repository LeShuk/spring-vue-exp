package ru.leshuk.springvueexp.security.model;

import lombok.Data;

@Data
public class AccountCredentials {
    private String username;
    private String password;
}
