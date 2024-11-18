package com.example.demo.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JWTRequest {
//    private String username;
    private String email;
    private String password;
}

