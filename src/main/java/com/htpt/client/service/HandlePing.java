package com.htpt.client.service;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.htpt.client.Common.Const;
import com.htpt.client.Models.Form.ResponsePing;

public class HandlePing {
    
    public String ping(String ipClient) {
        try {
            Const ct = new Const();
            // URI uri = new URI(host+"/api/ping"); 
            String url = ct.getHostCoordinator()+"/api/find-site/"+ipClient;
            SimpleClientHttpRequestFactory client = new SimpleClientHttpRequestFactory();
            client.setConnectTimeout(3000);
            client.setReadTimeout(3000);


            RestTemplate restTemplate = new RestTemplate(client);
            ResponsePing response = restTemplate.getForObject(url, ResponsePing.class);

            if(response != null)
                if(response.getStatus().equals("success")) 
                    return response.getData();

            return "";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }  
}
