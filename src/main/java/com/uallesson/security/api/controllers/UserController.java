package com.uallesson.security.api.controllers;

import com.uallesson.security.api.responses.ApplicationResponse;
import com.uallesson.security.domain.entities.User;
import com.uallesson.security.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ApplicationResponse getUsers() {
        try {
            List<User> usersList = userService.findAll();
            return ApplicationResponse.builder()
                    .data(usersList)
                    .build();

        } catch (Exception e) {
            return ApplicationResponse.builder()
                    .message(e.getMessage())
                    .status("error")
                    .build();
        }
    }


    @GetMapping("/username/{username}")
    public ApplicationResponse getUserByUsername(@PathVariable String username) {
        try {
            User user = userService.findByUsername(username);
            return ApplicationResponse.builder()
                    .data(user)
                    .build();

        } catch (Exception e) {
            return ApplicationResponse.builder()
                    .message(e.getMessage())
                    .status("error")
                    .build();
        }
    }


    @GetMapping("/email/{email}")
    public ApplicationResponse getUserByEmail(@PathVariable String email) {
        try {
            User user = userService.findByEmail(email);
            return ApplicationResponse.builder()
                    .data(user)
                    .build();

        } catch (Exception e) {
            return ApplicationResponse.builder()
                    .message(e.getMessage())
                    .status("error")
                    .build();
        }
    }


    @PutMapping("/update")
    public ApplicationResponse updateUser(@RequestBody User userUpdate) {
        try {
            User user = userService.updateUser(userUpdate);
            return ApplicationResponse.builder()
                    .data(user)
                    .build();

        } catch (Exception e) {
            return ApplicationResponse.builder()
                    .message(e.getMessage())
                    .status("error")
                    .build();
        }
    }

    @DeleteMapping("/delete/{username}")
    public ApplicationResponse deleteUser(@PathVariable String username) {
        try {
            userService.deleteUser(username);
            return ApplicationResponse.builder()
                    .message("User deleted successfully")
                    .build();

        } catch (Exception e) {
            return ApplicationResponse.builder()
                    .message(e.getMessage())
                    .status("error")
                    .build();
        }
    }
}
