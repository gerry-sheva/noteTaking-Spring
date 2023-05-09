package com.sheva.notetaking.service;

import com.sheva.notetaking.model.User;
import com.sheva.notetaking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findByUid(Integer uid){
        return userRepository.findByUid(uid);
    }
}
