package com.amirdehi.quvo.model.mapper;

import com.amirdehi.quvo.dto.request.UserRequest;
import com.amirdehi.quvo.dto.response.UserResponse;
import com.amirdehi.quvo.model.Role;
import com.amirdehi.quvo.model.Users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserMapper {

    public static UserResponse userToUserResponse(Users user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFullName(user.getFullName());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setRole(getRoleStringFromRole(user.getRole()));

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        userResponse.setCreationDate(dateFormat.format(user.getCreationDate()));
        return userResponse;
    }

    public static Users userRequestToUser(UserRequest userRequest){
        Users user = new Users();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setFullName(userRequest.getFullName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setRole(getRoleById(userRequest.getRole()));
        user.setCreationDate(Calendar.getInstance().getTime());
        return user;
    }

    public static Role getRoleById(int id){
        if (id == 1)
            return Role.ADMIN;
        if (id == 2)
            return Role.USER;
        return null;
    }

    public static String getRoleStringFromRole(Role role){
        if (role == Role.ADMIN)
            return "Admin";
        if (role == Role.USER)
            return "User";
        return "";
    }
}
