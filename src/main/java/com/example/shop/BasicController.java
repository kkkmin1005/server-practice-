package com.example.shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    @GetMapping("/")
    public String hello(){
        return "redirect:/index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "문강민입니다";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "마이페이지입니다";
    }

}
