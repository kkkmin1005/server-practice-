package com.example.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class RegisterController {

    private final UserInfoRepository userInfoRepository;

    @PostMapping("/register")
    String register(String username, String password, String displayName){

        UserInfo userInfo = new UserInfo();

        var encoder = new BCryptPasswordEncoder();

        userInfo.username = username;
        userInfo.password = encoder.encode(password);
        userInfo.displayName = displayName;

        userInfoRepository.save(userInfo);

        return "redirect:/list";
    }

    @GetMapping("/register-page")
    public String registerPage(){
        return "register.html";
    }

}
