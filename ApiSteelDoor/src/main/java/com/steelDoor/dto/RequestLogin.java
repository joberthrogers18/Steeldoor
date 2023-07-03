package com.steelDoor.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestLogin {
    private String email;
    private String password;
}
