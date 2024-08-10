package com.example.dietsoft.dietfood_backend.controllers;


import com.example.dietsoft.dietfood_backend.dto.UserCreateDTO;
import com.example.dietsoft.dietfood_backend.dto.UserDTO;
import com.example.dietsoft.dietfood_backend.services.UserService;
import com.example.dietsoft.dietfood_backend.entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserCtrl {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setName(userCreateDTO.getName());
        user.setEmail(userCreateDTO.getEmail());
        if (userCreateDTO.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        }

        UserDTO savedUser = userService.createUser(user);

        UserDTO responseDTO = new UserDTO();
        responseDTO.setName(savedUser.getName());
        responseDTO.setEmail(savedUser.getEmail());
        responseDTO.setCreatedAt(savedUser.getCreatedAt());
        responseDTO.setUpdatedAt(savedUser.getUpdatedAt());
        responseDTO.setPasswordLastUpdated(savedUser.getPasswordLastUpdated());

        return ResponseEntity.ok(responseDTO);
    }



    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID id) {
        Optional<UserDTO> userOpt = Optional.ofNullable(userService.getUserById(id));
        return userOpt.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

     @PutMapping("/{id}")
     public ResponseEntity<UserDTO> updateUser(@PathVariable UUID id, @RequestBody User user) {
         UserDTO updatedUser = userService.updateUser(id, user);
         return new ResponseEntity<>(updatedUser, HttpStatus.OK);
     }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    //     userService.deleteUser(id);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
}
