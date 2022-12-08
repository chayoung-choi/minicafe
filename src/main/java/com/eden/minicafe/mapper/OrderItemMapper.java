package com.eden.minicafe.mapper;

import com.eden.minicafe.domain.OrderItem;
import com.eden.minicafe.dto.OrderItemDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", // Spring Bean 으로 생성
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    @Mapping(source = "item.id", target = "itemId")
    OrderItemDto toDto(OrderItem orderItem);
    
    OrderItem toEntity(OrderItemDto orderItemDto);
}
