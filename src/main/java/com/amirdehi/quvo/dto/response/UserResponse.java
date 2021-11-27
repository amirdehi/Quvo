package com.amirdehi.quvo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserResponse {
    private int id;
    private String username;
    private String role;
    private String fullName;
    private String phone;
    private String email;
    private String creationDate;
}
