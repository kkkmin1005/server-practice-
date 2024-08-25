package com.example.shop;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final S3Service s3Service;

    @GetMapping("/list")
    public String list(Model model){
        var result = itemRepository.findAll();
        model.addAttribute("items",result);
        return "list.html";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(String title, Integer price){
        itemService.saveItem(title, price);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable Integer id, Model model){
        var result = itemRepository.findById(id);
        model.addAttribute("item",result.get());
        return "edit.html";
    }

    @PostMapping("/editpost/{id}")
    String editPost(@PathVariable Integer id, String title, Integer price){
        Item item = new Item();
        item.id = id;
        item.title = title;
        item.price = price;
        itemRepository.save(item);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Integer id, Model model){
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()){
            model.addAttribute("item", result.get());
        }
        return "detail.html";
    }

    @DeleteMapping("/delete")
    String deleteItem(@RequestParam Integer id){
        itemRepository.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("/list/page/1")
    public String getListPage(Model model){

        var result = itemRepository.findPageBy(PageRequest.of(0,5));
        model.addAttribute("items",result);
        return "list.html";
    }

    @GetMapping("/presigned-url")
    @ResponseBody
    String getURL(@RequestParam String filename){

        var result = s3Service.createPresignedUrl("test/" + filename);
        System.out.println(result);
        return result;
    }




}
