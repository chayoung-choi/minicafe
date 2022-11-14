package com.eden.minicafe.service;

import com.eden.minicafe.domain.item.Item;
import com.eden.minicafe.dto.ItemDto;
import com.eden.minicafe.exception.DuplicationException;
import com.eden.minicafe.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 상품 관련 비즈니스 로직
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

  private static final Integer DEFAULT_ITEM_STOCK = 100;
  private final ItemRepository itemRepository;

  /**
   * 상품 정보 신규 등록
   *
   * @param itemDto
   * @return 상품
   */
  @Transactional
  public Long saveItem(ItemDto itemDto) {
    if (itemRepository.existsByName(itemDto.getName())) {
      throw new DuplicationException("상품 이름", itemDto.getName());
    }
    return itemRepository.save(itemDto.toEntity()).getId();
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
