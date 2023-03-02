package com.borges.controllers;

import com.borges.models.dtos.input.UserInputDTO;
import com.borges.models.dtos.output.UserOutputDTO;
import com.borges.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserInputDTO> createUser(@RequestBody UserInputDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
    }

    @GetMapping
    public ResponseEntity<Page<UserOutputDTO>> FindAllUsers(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUsers(pageable));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserOutputDTO> findUserById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }
}
