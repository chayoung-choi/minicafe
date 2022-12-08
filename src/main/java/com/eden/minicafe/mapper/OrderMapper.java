package com.eden.minicafe.mapper;

import com.eden.minicafe.domain.Order;
import com.eden.minicafe.domain.OrderItem;
import com.eden.minicafe.dto.OrderDto;
import com.eden.minicafe.dto.OrderItemDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", // Spring Bean 으로 생성
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "user.id", target = "userId")
    OrderDto toDto(Order order);

    Order toEntity(OrderDto orderDto);


    List<OrderItemDto> toOrderItemDtoList(List<OrderItem> list);

    @Mapping(source = "item.id", target = "itemId")
    OrderItemDto toDto(OrderItem orderItem);
}
