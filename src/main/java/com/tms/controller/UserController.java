package com.tms.controller;

import com.tms.domain.Role;
import com.tms.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUser(Model model) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(10);
        userInfo.setFirstName("Dima");
        userInfo.setLastName("Bilan");
        userInfo.setRole(Role.ADMIN);

        UserInfo secondUserInfo = new UserInfo();
        secondUserInfo.setId(11);
        secondUserInfo.setFirstName("Anatolii");
        secondUserInfo.setLastName("Vaserman");
        secondUserInfo.setRole(Role.MODERATOR);

        List<UserInfo> users = new ArrayList<>();
        users.add(userInfo);
        users.add(secondUserInfo);

        model.addAttribute("users", users);
        return "user-page";
    }
}
