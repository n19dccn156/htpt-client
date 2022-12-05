package com.htpt.client.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htpt.client.service.HandlePing;

@RestController
@RequestMapping(value = "/api")
public class api {
    
    @GetMapping(value = "/ping")
    public String ping(HttpServletRequest request) {

        HandlePing pingResponse = new HandlePing();
        return pingResponse.ping(request.getRemoteAddr());
    }
}
