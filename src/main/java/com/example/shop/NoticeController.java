package com.example.shop;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeRepository noticeRepository;

    @GetMapping("/notice")
    String notice(Model model) {
        var result = noticeRepository.findAll();
        model.addAttribute("notice", result);
        return "notice.html";
    }
 }
