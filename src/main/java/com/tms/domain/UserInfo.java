package com.tms.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Schema(description = "Описание пользователя")
@Data
@EqualsAndHashCode(exclude = "updatedAt")
public class UserInfo {

    @Schema(description = "Это уникальный идентификатор пользователя")
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Role role;
}
