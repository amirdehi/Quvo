package com.amirdehi.quvo.repository;

import com.amirdehi.quvo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {
    Users findUsersByUsername(String username);
    Users findById(int id);
}
