package com.amirdehi.quvo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserRequest {
    private String username;
    private String password;
    private int role;
    private String fullName;
    private String phone;
    private String email;
}
