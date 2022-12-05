package com.htpt.client.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.htpt.client.Models.ResponseObject;
import com.htpt.client.Models.UserModel;
import com.htpt.client.Models.Form.LoginModel;
import com.htpt.client.service.HandleLogin;
import com.htpt.client.service.HandlePing;

@Controller
@RequestMapping
public class PostController {
    
    @PostMapping("/login")
    public String checkLogin(@ModelAttribute("login") LoginModel model, HttpSession session, Model validate, HttpServletRequest request) {

        HandlePing pingResponse = new HandlePing();
        HandleLogin handleLogin = new HandleLogin();

        String ipClient = request.getRemoteAddr();
        String serverResponse = pingResponse.ping(ipClient);
        if(serverResponse.equals("") || serverResponse.equals(null)) {
            validate.addAttribute("error", "Server đang bảo trì");
            return "login";
        }
        ResponseObject response = handleLogin.basicPost(serverResponse, model, ipClient);

        if(response.getStatus().equals("failed")) {

            validate.addAttribute("error", response.getMessage());
            return "login";
        }

        try {
            JSONObject jsonObject = new JSONObject(response.getData().toJson());
            UserModel user = new UserModel(jsonObject.getString("email"),
                                            jsonObject.getString("password"),
                                            jsonObject.getString("firstName"),
                                            jsonObject.getString("lastName"),
                                            jsonObject.getString("job"));
            session.removeAttribute("user");
            session.setAttribute("user", user);

            return "redirect:/profile";
        }catch (JSONException err){
            validate.addAttribute("error", err.getMessage());
            return "login";
        }

    }
    
    // @PostMapping("/signup")
    // public String checkSignup(@ModelAttribute("signup") SignupModel model, Model validate) {
        
    //     if(model.getPass1().trim().equals(model.getPass2().trim())) {

    //         validate.addAttribute("error", "Nhập lại mật khẩu không đúng");
    //         return "signup";
    //     }
    // }


}
