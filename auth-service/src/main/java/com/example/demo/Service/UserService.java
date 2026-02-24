package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Security.JwtService;

@Service
public class UserService {

@Autowired
UserRepository repo;

@Autowired
JwtService jwt;

BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

public String register(User user){

user.setPassword(encoder.encode(user.getPassword()));
repo.save(user);

return "User Registered";
}

public String login(String email,String password){

User user=repo.findByEmail(email).orElseThrow();

if(encoder.matches(password,user.getPassword())){

return jwt.generateToken(email,user.getRole());

}

throw new RuntimeException("Invalid login");
}

}