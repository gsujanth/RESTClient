package com.neverstop.RESTClient;

import com.neverstop.RESTClient.model.UserEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/restClient")
public class RESTClientController {

    @GetMapping("/get")
    public String doGetCall(){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8083/userevents/";
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        return response.getBody();
        //List userEventsList = restTemplate.getForObject(resourceUrl, List.class);
        //return userEventsList.toString();
        //HttpHeaders httpHeaders = restTemplate.headForHeaders(resourceUrl);
    }

    @GetMapping("/post")
    public UserEvent doPostCall(){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8083/userevents/userevent";
        HttpEntity<UserEvent> request = new HttpEntity<>(new UserEvent(68699L,"promotion","gsb",5767L,"promo"));
        ResponseEntity<UserEvent> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request, UserEvent.class);
        System.out.println("Status: "+response.getStatusCode());
        return response.getBody();
        //UserEvent userEvent = restTemplate.postForObject(resourceUrl, request, UserEvent.class);
        //URI location = restTemplate.postForLocation(resourceUrl, request);
    }
}
