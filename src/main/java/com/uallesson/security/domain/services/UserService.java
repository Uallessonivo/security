package com.uallesson.security.domain.services;

import com.uallesson.security.domain.entities.User;
import com.uallesson.security.domain.exceptions.DomainException;
import com.uallesson.security.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll(){
        List<User> userList = userRepository.findAll();

        if (userList.isEmpty()) {
            throw new DomainException("No users found");
        }

        return userList;
    }

    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new DomainException("User not found");
        }

        return user.get();
    }

    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new DomainException("User not found");
        }

        return user.get();
    }

    public User updateUser(User user) {
        Optional<User> userToUpdate = userRepository.findByEmail(user.getEmail());

        if (userToUpdate.isEmpty()) {
            throw new DomainException("User not found");
        }

        User updatedUser = userToUpdate.get();

        updatedUser.setEmail(user.getEmail());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(updatedUser);

        return user;
    }

    public void deleteUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new DomainException("User not found");
        }

        userRepository.delete(user.get());
    }
}
