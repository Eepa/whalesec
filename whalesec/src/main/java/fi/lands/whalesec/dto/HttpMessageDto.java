package fi.lands.whalesec.dto;

import java.util.Map;

public class HttpMessageDto {

    private final Map<String, String> headers;

    public HttpMessageDto(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

}
