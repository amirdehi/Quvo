package com.amirdehi.quvo.service.implementations;

import com.amirdehi.quvo.dto.request.UserRequest;
import com.amirdehi.quvo.dto.response.UserResponse;
import com.amirdehi.quvo.model.Users;
import com.amirdehi.quvo.model.mapper.UserMapper;
import com.amirdehi.quvo.repository.UserRepository;
import com.amirdehi.quvo.service.interfaces.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public boolean createUser(UserRequest user) {
        Users users = userRepository.save(UserMapper.userRequestToUser(user));
        return users != null;
    }

    @Override
    public UserResponse readUser(int id) {
        Users user = userRepository.getById(id);
        return UserMapper.userToUserResponse(user);
    }

    @Override
    public UserResponse readUser(String username) {
        Users user = userRepository.findUsersByUsername(username);
        return UserMapper.userToUserResponse(user);
    }

    @Override
    public boolean updateUser(UserRequest user) {
        Users users = userRepository.save(UserMapper.userRequestToUser(user));
        return users != null;
    }

    @Override
    public boolean deleteUser(String username) {
        Users user = userRepository.findUsersByUsername(username);
        if (user == null)
            return false;
        userRepository.delete(user);
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        Users user = userRepository.getById(id);
        if (user == null)
            return false;
        userRepository.delete(user);
        return true;
    }
}
