//package com.example.sociallogin.controller;
//
//import com.nimbusds.jose.shaded.gson.Gson;
//import com.nimbusds.jose.shaded.gson.GsonBuilder;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.token.Token;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Base64;
//
//import static com.nimbusds.jose.shaded.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
//
//@RestController
//@RequestMapping("/api/v1")
//@Slf4j
//public class UserController {
//
//    @GetMapping("/user")
//    public String user() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//    }
//    @GetMapping("/get-token")
//    public String getToken(@RequestHeader(name = "Authorization") String authorization) {
//        String tokenStr = authorization.substring(7);
//        String[] parts = tokenStr.split("\\.");
//        Base64.Decoder decoder = Base64.getUrlDecoder();
//        String payload = new String(decoder.decode(parts[1]));
//        log.info("(doFilter)payload: {}", payload);
//// deserialize
//        Gson gson = new GsonBuilder().setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES).create();
//        Token token = gson.fromJson(payload, Token.class);
//        log.info("(doFilter)token : {}", token);
//        return token.;
//    }
//}
//
