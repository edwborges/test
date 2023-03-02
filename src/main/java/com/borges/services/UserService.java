package com.borges.services;

import com.borges.exceptions.EntityNotFoundException;
import com.borges.mappers.input.UserInputMapper;
import com.borges.mappers.output.UserOutputMapper;
import com.borges.models.dtos.input.UserInputDTO;
import com.borges.models.dtos.output.UserOutputDTO;
import com.borges.models.entities.User;
import com.borges.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserInputDTO createUser(UserInputDTO userInputDTO) {
        var user = UserInputMapper.INSTANCE.DTOToEntity(userInputDTO);
        User save = this.userRepository.save(user);
        return UserInputMapper.INSTANCE.entityToDTO(save);
    }

    @Transactional
    public Page<UserOutputDTO> findAllUsers(Pageable pageable) {
        var test = userRepository.findAll(pageable);
        return UserOutputMapper.INSTANCE.pageEntitytoPageDTO(test);
    }

    @Transactional
    public UserOutputDTO findById(UUID id) {
        var test = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID not found"));
        return UserOutputMapper.INSTANCE.entityToDTO(test);
    }
}
