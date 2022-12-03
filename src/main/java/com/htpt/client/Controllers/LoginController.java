package com.htpt.client.Controllers;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.htpt.client.Models.ResponseObject;
import com.htpt.client.Models.UserModel;
import com.htpt.client.Models.Form.LoginModel;
import com.htpt.client.service.HandleLogin;

@Controller
@RequestMapping
public class LoginController {
    
    @GetMapping("/login")
    public String login() {
            
        return "login";
    }

    @PostMapping("/login")
    public String checkLogin(@ModelAttribute("login") LoginModel model, RedirectAttributes redirectAttributes, Model validate) {

        String host = "http://192.168.10.108:8082";
        HandleLogin handleLogin = new HandleLogin();
        ResponseObject response = handleLogin.basicPost(host, model);

        if(response.getStatus().equals("failed")) {

            validate.addAttribute("error", response.getMessage());
            return "login";
        }

        UserModel user;
        try {
            user = new ObjectMapper().readValue(response.getData().toString(), UserModel.class);
        
            System.out.println(user.getEmail());
            return "redirect:/profile";
        } catch (JsonMappingException e) {
            validate.addAttribute("error", e.getMessage());
            return "login";
        } catch (JsonProcessingException e) {
            validate.addAttribute("error", e.getMessage());
            return "login";
        }  

    }

    @GetMapping("/profile")
    public String profile() {

        return "profile";
    }
}
