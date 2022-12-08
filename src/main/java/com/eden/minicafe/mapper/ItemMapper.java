package com.eden.minicafe.mapper;

import com.eden.minicafe.domain.item.Coffee;
import com.eden.minicafe.domain.item.Drink;
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

    ItemDto toDto(Coffee coffee);

    Coffee toEntityOfCoffee(ItemDto itemDto);

    Drink toEntityOfDrink(ItemDto itemDto);
}
