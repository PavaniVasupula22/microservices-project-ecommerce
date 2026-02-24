package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.UserService;
import com.example.demo.Security.JwtService;
import com.example.demo.Entity.User;

@RestController
@RequestMapping("/auth")
public class UserController {

@Autowired
UserService service;

@Autowired
JwtService jwt;

@PostMapping("/register")
public String register(@RequestBody User user){

return service.register(user);
}

@PostMapping("/login")
public String login(@RequestBody User user){

return service.login(user.getEmail(),user.getPassword());
}

@GetMapping("/validate")
public boolean validate(@RequestHeader("Authorization") String token){

return jwt.validateToken(token.replace("Bearer ",""));
}

}