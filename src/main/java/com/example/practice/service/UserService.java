package com.example.practice.service;

import com.example.practice.model.RoleType;
import com.example.practice.model.User;
import com.example.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void 회원가입(User user){
        String rawPW = user.getPassword();
        String encPW = encoder.encode(rawPW);
        user.setPassword(encPW);
        user.setRole(RoleType.USER);
        userRepository.save(user);

    }

    @Transactional
    public void 회원수정(User user){
        User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException("회원 찾기 실패");
        });

        if (persistance.getOauth()==null || persistance.getOauth().equals("")){
            String rawPW = user.getPassword();
            String encPW = encoder.encode(rawPW);
            persistance.setPassword(encPW);
            persistance.setEmail(user.getEmail());
        }

    }

    public User 회원찾기(String username){
        User user = userRepository.findByUsername(username).orElseGet(()->{
            return new User();
        });
        return user;
    }

}
