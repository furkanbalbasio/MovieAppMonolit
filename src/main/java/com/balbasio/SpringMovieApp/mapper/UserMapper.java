package com.balbasio.SpringMovieApp.mapper;

import com.balbasio.SpringMovieApp.dto.request.UserRegisterRequestDto;
import com.balbasio.SpringMovieApp.dto.response.LoginResponseDto;
import com.balbasio.SpringMovieApp.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    User fromRegisterRequestToUser(final UserRegisterRequestDto dto);
    LoginResponseDto fromUserToLoginResponseDto(final User user);
}
