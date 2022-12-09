package com.eden.minicafe.mapper;

import com.eden.minicafe.domain.item.*;
import com.eden.minicafe.dto.ItemDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", // Spring Bean 으로 생성
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입
        unmappedTargetPolicy = ReportingPolicy.IGNORE // 매핑 오류시 무시
)
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDto toDto(Item item);

    ItemDto toDto(Coffee coffee);

    ItemDto toDto(Drink drink);

    ItemDto toDto(Food food);

    ItemDto toDto(Tea tea);

    default Item toEntity(ItemDto itemDto) {
        switch (itemDto.getCategory()) {
            case COFFEE -> {
                Coffee coffee = new Coffee();
                coffee.setId(itemDto.getItemId());
                coffee.setName(itemDto.getName());
                coffee.setStock(itemDto.getStock());
                coffee.setPrice(itemDto.getPrice());
                coffee.setOrigin(itemDto.getOrigin());
                return coffee;
            }
            case DRINK -> {
                Drink drink = new Drink();
                drink.setId(itemDto.getItemId());
                drink.setName(itemDto.getName());
                drink.setStock(itemDto.getStock());
                drink.setPrice(itemDto.getPrice());
                return drink;
            }
            case FOOD -> {
                Food food = new Food();
                food.setId(itemDto.getItemId());
                food.setName(itemDto.getName());
                food.setStock(itemDto.getStock());
                food.setPrice(itemDto.getPrice());
                food.setShelfLifeDate(itemDto.getShelfLifeDate());
                return food;
            }
            case TEA -> {
                Tea tea = new Tea();
                tea.setId(itemDto.getItemId());
                tea.setName(itemDto.getName());
                tea.setStock(itemDto.getStock());
                tea.setPrice(itemDto.getPrice());
                tea.setOrigin(itemDto.getOrigin());
                return tea;
            }
        }
        throw new IllegalArgumentException("정의되지 않은 카테고리입니다.");
    }
}
