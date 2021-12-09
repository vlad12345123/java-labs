package ru.vzezj.EmployeeAssesment.Service;

import com.sun.istack.NotNull;
import ru.vzezj.EmployeeAssesment.model.request.CreateUserRequest;
import ru.vzezj.EmployeeAssesment.model.response.UserResponse;

import java.util.List;

public interface UserService {

    @NotNull
    List<UserResponse> findAll();

    @NotNull
    UserResponse findById(@NotNull Integer userId);

    @NotNull
    UserResponse createUser(@NotNull CreateUserRequest request);

    @NotNull
    UserResponse update(@NotNull Integer userId, @NotNull CreateUserRequest request);

    void delete(@NotNull Integer userId);
}


