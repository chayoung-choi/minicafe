package com.eden.minicafe.service;

import com.eden.minicafe.domain.Category;
import com.eden.minicafe.domain.item.Item;
import com.eden.minicafe.dto.ItemDto;
import com.eden.minicafe.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemService itemService;

    @DisplayName("상품 신규 등록")
    @Test
    void saveItem() {
        ItemDto itemDto = ItemDto.builder()
                .name("카페모카")
                .price(3000)
                .category(Category.COFFEE).build();
        Long itemId = itemService.saveItem(itemDto);

        Item item = itemRepository.findById(itemId).get();
        assertThat(item.getName()).isEqualTo(itemDto.getName());
    }

    @Test
    void get_item() {
//        Item item = itemService.findById(1L);
//        System.out.printf(item.getCategory().name());
//        Coffee coffee = (Coffee) itemService.findById(1L);
//        System.out.printf(coffee.getOrigin());

    }
}
