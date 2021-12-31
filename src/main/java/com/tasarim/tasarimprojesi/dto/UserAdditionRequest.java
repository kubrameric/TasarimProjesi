package com.tasarim.tasarimprojesi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAdditionRequest {
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
}
