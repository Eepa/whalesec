package fi.lands.catback.controller;

import java.util.HashMap;
import java.util.Map;
import fi.lands.catback.dto.HttpMessageDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MauController {

    @GetMapping("/")
    public String helloMau() {
        return "Hello cats!";
    }

    // You can comment out this if you want to test how the HEAD method works for the path "/greeting"

//    @RequestMapping(method = RequestMethod.HEAD, path = "/greeting")
//    public String headGreeting() {
//        return "Static greeting!";
//    }

    @GetMapping("/greeting")
    public String getGreeting(@RequestParam String greeting) {
        return greeting;
    }

    @GetMapping("/echorequest")
    public HttpMessageDto echoRequest(HttpServletRequest request) {

        Map<String, String> headers = new HashMap<>();
        request.getHeaderNames().asIterator()
            .forEachRemaining(name -> headers.put(name, request.getHeader(name)));

        return new HttpMessageDto(headers);
    }
}
