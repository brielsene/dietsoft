package com.example.dietsoft.dietfood_backend.services;

import com.example.dietsoft.dietfood_backend.dto.UserDTO;
import com.example.dietsoft.dietfood_backend.entities.User;
import com.example.dietsoft.dietfood_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserDTO createUser(User userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user = userRepository.save(user);

        return convertToDTO(user); // Retorna o DTO com datas
    }

    public UserDTO getUserById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return convertToDTO(optionalUser.get());
        } else {
            // Tratar caso o usuário não seja encontrado
            return null; // Ou lançar uma exceção
        }
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .toList();
    }

    public UserDTO updateUser(UUID id, User userCreateDTO) {
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

            user.setName(userCreateDTO.getName());
            user.setEmail(userCreateDTO.getEmail());

            if (userCreateDTO.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
            }

            User updatedUser = userRepository.save(user);

            UserDTO responseDTO = new UserDTO();
            responseDTO.setName(updatedUser.getName());
            responseDTO.setEmail(updatedUser.getEmail());
            responseDTO.setCreatedAt(updatedUser.getCreatedAt());
            responseDTO.setUpdatedAt(updatedUser.getUpdatedAt());
            responseDTO.setPasswordLastUpdated(updatedUser.getPasswordLastUpdated());

            return responseDTO;
        }
        catch (RuntimeException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUuid(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt()); // Inclui a data de criação
        userDTO.setUpdatedAt(user.getUpdatedAt()); // Inclui a data de atualização
        // Senha não incluída no DTO de resposta
        return userDTO;
    }

}
