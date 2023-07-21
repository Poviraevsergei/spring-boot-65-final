package com.tms.controller;

import com.tms.domain.Role;
import com.tms.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUser(Model model){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(10);
        userInfo.setFirstName("Dima");
        userInfo.setLastName("Bilan");
        userInfo.setRole(Role.ADMIN);
        model.addAttribute("name",userInfo.getFirstName());
        return "user-page";
    }
}
