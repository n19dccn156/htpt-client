package com.htpt.client.service;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.htpt.client.Models.ResponseObject;
import com.htpt.client.Models.UserModel;
import com.htpt.client.Models.Form.LoginModel;

public class HandleLogin {
    
    public ResponseObject basicPost(String host, LoginModel model, String ipClient) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            SimpleClientHttpRequestFactory client = new SimpleClientHttpRequestFactory();
            client.setConnectTimeout(3000);
            client.setReadTimeout(2000);
            
            URI uri = new URI(host+"/api/signin/"+ipClient);  

            HttpEntity<LoginModel> httpEntity = new HttpEntity<>(model, headers);

            RestTemplate restTemplate = new RestTemplate(client);
            ResponseObject result = (ResponseObject) restTemplate.postForObject(uri, httpEntity, ResponseObject.class);

            if(result != null) return result;
            return new ResponseObject("failed", "Login failed", new UserModel());
        } catch (Exception e) {
            return new ResponseObject("failed", "Tài khoản hoặc mật khẩu không đúng", new UserModel());
        }
      }  
}
