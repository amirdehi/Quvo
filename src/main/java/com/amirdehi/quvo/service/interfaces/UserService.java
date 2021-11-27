package com.amirdehi.quvo.service.interfaces;

import com.amirdehi.quvo.dto.request.UserRequest;
import com.amirdehi.quvo.dto.response.UserResponse;

public interface UserService {
    boolean createUser(UserRequest user);
    UserResponse readUser(int id);
    UserResponse readUser(String username);
    boolean updateUser(UserRequest user);
    boolean deleteUser(int id);
    boolean deleteUser(String username);
}
