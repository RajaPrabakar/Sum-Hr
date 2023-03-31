package com.sum.hr.sum.hr;

import com.sum.hr.sum.hr.MODEL.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil
{

    private static String secret="This is My secret";

    public  Object generateJWT(Users users)
    {
            Claims claims = Jwts.claims().setIssuer(users.getUserName()).setId(String.valueOf(users.getUserId()));
            return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }


    public Claims verifyJWT(String authentication) throws Exception
    {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authentication).getBody();
            return claims;
        }
        catch (IllegalArgumentException e)
        {
            throw  new IllegalArgumentException("UnAuthorized");
        }
    }

}
