package com.eden.minicafe.controller;

import com.eden.minicafe.domain.item.Item;
import com.eden.minicafe.dto.ItemDto;
import com.eden.minicafe.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    /**
     * 상품 등록
     *
     * @param itemDto 상품 정보
     * @return 생성된 상품 정보
     */
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    Long createItem(@RequestBody @Valid ItemDto itemDto) {
        return itemService.saveItem(itemDto);
    }

    /**
     * 상품 정보 전체 조회
     *
     * @return 상품 정보
     */
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    List<Item> getItems() {
        return itemService.getItems();
    }
}

