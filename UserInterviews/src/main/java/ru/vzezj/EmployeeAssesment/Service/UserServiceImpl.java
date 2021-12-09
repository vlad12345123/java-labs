package ru.vzezj.EmployeeAssesment.Service;

import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vzezj.EmployeeAssesment.domain.User;
import ru.vzezj.EmployeeAssesment.model.request.CreateUserRequest;
import ru.vzezj.EmployeeAssesment.model.response.UserResponse;
import ru.vzezj.EmployeeAssesment.model.request.CreateInterviewResultsRequest;
import ru.vzezj.EmployeeAssesment.model.response.InterviewResultsResponse;
import ru.vzezj.EmployeeAssesment.repository.UserRepository;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static UserRepository userRepository;

    //get all users
    @NotNull
    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::buildUserResponse)
                .collect(Collectors.toList());
    }

    //get user by id
    @NotNull
    @Override
    @Transactional(readOnly = true)
    public UserResponse findById(@NotNull Integer userId) {
        return userRepository.findById(userId)
                .map(this::buildUserResponse)
                .orElseThrow(() -> new EntityNotFoundException("User " + userId + " is not found"));
    }

    //create user
    @NotNull
    @Override
    @Transactional
    public UserResponse createUser(@NotNull CreateUserRequest request) {
        User user = buildUserRequest(request);
        return buildUserResponse(userRepository.save(user));
    }

    //upd user
    @NotNull
    @Override
    @Transactional
    public UserResponse update(@NotNull Integer userId, @NotNull CreateUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User " + userId + " is not found"));
        userUpdate(user, request);
        return buildUserResponse(userRepository.save(user));
    }

    //delete user
    @Override
    @Transactional
    public void delete(@NotNull Integer userId) {
        userRepository.deleteById(userId);
    }

    @NotNull
    private UserResponse buildUserResponse(@NotNull User user) {
        return new UserResponse()
                .setId(user.getId())
                .setLogin(user.getLogin())
                .setAge(user.getAge())
                .setFirstName(user.getFirstName())
                .setMiddleName(user.getMiddleName())
                .setLastName(user.getLastName());
    }

    @NotNull
    private User buildUserRequest(@NotNull CreateUserRequest request) {
        return new User()
                .setLogin(request.getLogin())
                .setAge(request.getAge())
                .setFirstName(request.getFirstName())
                .setMiddleName(request.getMiddleName())
                .setLastName(request.getLastName())
    }

    private void userUpdate(@NotNull User user, @NotNull CreateUserRequest request) {
        ofNullable(request.getLogin()).map(user::setLogin);
        ofNullable(request.getFirstName()).map(user::setFirstName);
        ofNullable(request.getMiddleName()).map(user::setMiddleName);
        ofNullable(request.getLastName()).map(user::setLastName);
        ofNullable(request.getAge()).map(user::setAge);
    }
}
