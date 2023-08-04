package com.tms.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.tms.domain.Role;
import com.tms.domain.UserInfo;
import com.tms.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    UserService userService;
    static UserInfo userInfo;

    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    public static void beforeAll() {
        userInfo = new UserInfo();
        userInfo.setId(10);
        userInfo.setFirstName("Dima");
        userInfo.setLastName("Gorohov");
        userInfo.setRole(Role.USER);
    }

    @Test
    public void getUserTest() throws Exception {
        Mockito.when(userService.getUser(10)).thenReturn(userInfo);

        mockMvc.perform(get("/").param("id","10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", Matchers.is("Dima")));
    }
}
