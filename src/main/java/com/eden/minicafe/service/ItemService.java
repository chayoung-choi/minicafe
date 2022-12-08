package com.eden.minicafe.service;

import com.eden.minicafe.domain.item.Item;
import com.eden.minicafe.dto.ItemDto;
import com.eden.minicafe.dto.ItemMapper2;
import com.eden.minicafe.exception.DuplicationException;
import com.eden.minicafe.mapper.ItemMapper;
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
    private final ItemRepository itemRepository;

    /**
     * 상품 정보 신규 등록
     *
     * @param itemDto 상품 정보
     * @return 상품 id
     */
    @Transactional
    public Long saveItem(ItemDto itemDto) {
        Item item = ItemMapper.INSTANCE.toEntityOfCoffee(itemDto);
        if (itemRepository.existsByName(itemDto.getName())) {
            throw new DuplicationException("상품 이름", itemDto.getName());
        }
        return itemRepository.save(ItemMapper2.of(itemDto)).getId();
    }

    /**
     * 상품 전체 조회
     *
     * @return list 상품
     */
    public List<ItemDto> getItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(ItemMapper2::of).toList();
    }
}
