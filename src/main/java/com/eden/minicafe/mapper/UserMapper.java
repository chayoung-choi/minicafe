package com.eden.minicafe.mapper;

import com.eden.minicafe.domain.User;
import com.eden.minicafe.dto.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", // Spring Bean 으로 생성
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입
        unmappedTargetPolicy = ReportingPolicy.IGNORE // 매핑 오류시 무시
)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

}
