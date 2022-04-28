package com.example.demo.util;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.entity.jwtresponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class jwtTokenUtil {

		private static final long JWT_TOKEN_VALIDAITY = 5*60*60;

		@Value("${jwt.secret}")
		private String secret;
		
		public String generateToken(UserDetails userdetail) {
			
			
			Map<String,Object> claims=new HashMap<>();
			
			return	Jwts.builder()
			.setClaims(claims)
			.setSubject(userdetail.getUsername())
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() +JWT_TOKEN_VALIDAITY*1000))
			.signWith(SignatureAlgorithm.HS512, secret)
			.compact();
			 
			
		}
}
