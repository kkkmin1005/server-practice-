package com.example.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){
        Item item = new Item();
        item.title = title;
        item.price = price;
        itemRepository.save(item);
    }

}
