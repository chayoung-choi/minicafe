package com.eden.minicafe.service;

import com.eden.minicafe.domain.Item;
import com.eden.minicafe.dto.ItemCreateDto;
import com.eden.minicafe.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 상품 관련 비즈니스 로직
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

  private final ItemRepository itemRepository;

  /**
   * 상품 정보 신규 등록
   *
   * @param itemDto
   * @return 상품
   */
  @Transactional
  public Item createItem(ItemCreateDto itemDto) {
    Item item = Item.builder()
        .name(itemDto.getName())
        .category(itemDto.getCategory())
        .price(itemDto.getPrice())
        .stock(Optional.ofNullable(itemDto.getStock()).orElse(0))
        .build();
    return itemRepository.save(item);
  }

  /**
   * 상품 전체 조회
   *
   * @return list 상품
   */
  public List<Item> getItems() {
    return itemRepository.findAll();
  }

}
