package com.borges.mappers.output;

import com.borges.mappers.generic.GenericMapper;
import com.borges.models.dtos.input.UserInputDTO;
import com.borges.models.dtos.output.UserOutputDTO;
import com.borges.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserOutputMapper extends GenericMapper<User, UserOutputDTO> {

    UserOutputMapper INSTANCE = Mappers.getMapper(UserOutputMapper.class);
}
