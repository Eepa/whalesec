package fi.lands.whaleback.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class WhaleController {

    private final Map<String, String> whales;

    public WhaleController() {
        this.whales = Map.of("1", "Miekkavalas", "2", "Sinivalas", "3", "Ryhävalas", "4", "Maitovalas");
    }

    @GetMapping("/whale/{id}")
    public ResponseEntity<String> getWhale(@PathVariable String id) {

        if (id == null || !whales.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(whales.get(id), HttpStatus.OK);
    }

    // http://whaleback.test.local/whale/caps/2%0d%0aSet-Cookie%3Asessiontoken%3D123ABC
    // This method is not vulnerable
    @GetMapping("/whale/caps/{id}")
    public String getWhaleRedirect(@PathVariable String id, HttpServletResponse response) {
        String encodedId = URLEncoder.encode(id, StandardCharsets.UTF_8);
        String path = "/whale/" + id;
        String redirectUrl = "http://whaleback.test.local";
        return "redirect:" + redirectUrl + path;
    }

}
