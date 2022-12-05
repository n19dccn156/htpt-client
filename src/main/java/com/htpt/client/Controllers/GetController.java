package com.htpt.client.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.htpt.client.Models.UserModel;

@Controller
@RequestMapping
public class GetController {
    
    @GetMapping("/login")
    public String login() {
            
        return "login";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session) {

        UserModel user = (UserModel) session.getAttribute("user");
        if(user == null || user.getEmail() == null || user.getEmail() == "") {
            return "redirect:/login";
        }

        return "profile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.removeAttribute("user");

        return "redirect:/login";
    }

    // @GetMapping("/update")
    // public String update() {

    //     return "/update";
    // }

    // @GetMapping("/signup")
    // public String sigup() {

    //     return "/signup";
    // }

}
