package fi.lands.whaleback.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import fi.lands.whaleback.dto.GreetingDto;
import fi.lands.whaleback.dto.HttpMessageDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    @GetMapping("/")
    public String helloWhales() {
        return "Hello whales!";
    }

    @PostMapping("/greeting")
    public String postGreeting(@RequestBody GreetingDto greeting, HttpServletRequest request) {
        return greeting.getGreeting();
    }

    @PutMapping("/greeting")
    public String putGreeting(@RequestBody GreetingDto greeting) {
        return greeting.getGreeting();
    }

    // You can comment out these if you want to test how the HEAD method works for the path "/greeting"

//    @RequestMapping(method = RequestMethod.HEAD, path = "/greeting")
//    public String headGreeting(@RequestBody GreetingDto greeting) {
//        return greeting.getGreeting();
//    }
//
//    @GetMapping("/greeting")
//    public String getGreeting() {
//        return "Static greeting!";
//    }

    @GetMapping("/echorequest")
    public HttpMessageDto echoRequest(HttpServletRequest request) {

        Map<String, String> headers = new HashMap<>();
        request.getHeaderNames().asIterator()
            .forEachRemaining(name -> headers.put(name, request.getHeader(name)));

        return new HttpMessageDto(headers);
    }
}
