package com.sheva.notetaking.repository;

import com.sheva.notetaking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long > {

    List<User> searchByEmail(String keyword);

    User findByUid(Integer uid);

    User findByUsername(String username);
}
