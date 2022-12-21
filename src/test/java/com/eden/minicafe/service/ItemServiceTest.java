package com.eden.minicafe.service;

import com.eden.minicafe.domain.Category;
import com.eden.minicafe.domain.item.Item;
import com.eden.minicafe.dto.ItemDto;
import com.eden.minicafe.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemService itemService;

    @DisplayName("상품 신규 등록을 하면 itemId를 반환한다")
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

    @DisplayName("상품 id로 상품 정보를 조회한다")
    @Test
    void findById() {
        ItemDto itemDto = itemService.findById(1L);
        System.out.println(itemDto.toString());
        assertThat(itemDto.getItemId()).isEqualTo(1);
    }

    @DisplayName("상품 전체 조회")
    @Test
    void findAll() {
        List<ItemDto> itemDtoList = itemService.findAll(null);
        itemDtoList.stream().forEach(System.out::println);
        itemDtoList.stream().map(itemDto -> assertThat(itemDto.getItemId()).isNotNull());
    }
}
