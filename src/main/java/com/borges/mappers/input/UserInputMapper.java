package com.borges.mappers.input;

import com.borges.mappers.generic.GenericMapper;
import com.borges.models.dtos.input.UserInputDTO;
import com.borges.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInputMapper extends GenericMapper<User, UserInputDTO> {

    UserInputMapper INSTANCE = Mappers.getMapper(UserInputMapper.class);
}
