package ru.vzezj.EmployeeAssesment.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vzezj.EmployeeAssesment.Service.UserService;
import ru.vzezj.EmployeeAssesment.model.request.CreateUserRequest;
import ru.vzezj.EmployeeAssesment.model.response.UserResponse;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/{userId}", produces = APPLICATION_JSON_VALUE)
    public UserResponse findById(@PathVariable Integer userId) {
        return userService.findById(userId);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PatchMapping(value = "/{userId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserResponse update(@PathVariable Integer userId, @RequestBody CreateUserRequest request) {
        return userService.update(userId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{userId}", produces = APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer userId) {
        userService.delete(userId);
    }
}
