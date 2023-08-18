package com.tms.controller;

import com.tms.domain.UserInfo;
import com.tms.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //для REST архитектуры
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserInfo>> getUsers() {
        List<UserInfo> users = userService.getUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getUser(@PathVariable @Parameter(description = "Это id пользователя") Integer id) {
        UserInfo userInfo = userService.getUser(id);
        if (userInfo != null) {
            return new ResponseEntity<>(userInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Добавляем пользователя", description = "Мы добавляем пользователя, нужно на вход передать json UserInfo!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Мы успешно создали пользователя"),
            @ApiResponse(responseCode = "409", description = "Не получилось создать пользователя"),
            @ApiResponse(responseCode = "400", description = "Ошибка со стороны клиента"),
            @ApiResponse(responseCode = "500", description = "Ошибка на сервере")
    })
    @PostMapping
    public ResponseEntity<HttpStatus> createUser(@RequestBody @Parameter(description = "пользователь которого добавляем") UserInfo userInfo) {
        UserInfo userInfoSaved = userService.createUser(userInfo);
        UserInfo userInfoResult = userService.getUser(userInfoSaved.getId());
        if (userInfoResult != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {

            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @Tag(name = "Test tag", description = "This is our test tag description!")
    @PutMapping
    public ResponseEntity<HttpStatus> updateUser(@RequestBody UserInfo userInfo) {
        userService.updateUser(userInfo);
        UserInfo userInfoUpdated = userService.getUser(userInfo.getId());
        if (userInfo.equals(userInfoUpdated)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id) {
        UserInfo userInfoUpdated = userService.getUser(id);
        userService.deleteUserById(userInfoUpdated);
        UserInfo userInfo = userService.getUser(id);
        if (userInfo == null && userInfoUpdated != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
