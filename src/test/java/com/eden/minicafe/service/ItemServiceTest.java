package com.eden.minicafe.service;

import com.eden.minicafe.domain.item.Coffee;
import com.eden.minicafe.domain.item.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Test
    void test() {

        Item item = new Coffee();
        item.setName("아이스 라떼");
        item.setPrice(5000);
//        itemService.saveItem(item);

    }

    @Test
    void get_item() {
//        Item item = itemService.findById(1L);
//        System.out.printf(item.getCategory().name());
//        Coffee coffee = (Coffee) itemService.findById(1L);
//        System.out.printf(coffee.getOrigin());

    }
}
