package com.example.demo.Security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class JwtService {

private String SECRET="mysecretkey";

public String generateToken(String email,String role){

return Jwts.builder()
.setSubject(email)
.claim("role",role)
.setIssuedAt(new Date())
.setExpiration(new Date(System.currentTimeMillis()+86400000))
.signWith(SignatureAlgorithm.HS256,SECRET)
.compact();
}

public boolean validateToken(String token){

try{
Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
return true;
}catch(Exception e){
return false;
}
}

}