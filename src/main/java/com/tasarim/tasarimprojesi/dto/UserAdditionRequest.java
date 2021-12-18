package com.tasarim.tasarimprojesi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAdditionRequest {
    private String name;
    private String surname;
    private Integer age;
    private String city;
    private String email;
    private String username;
    private String phoneNumber;
    private String address;
    private String password;
}
