package com.fabrick.testapp.utility;

import org.springframework.http.HttpHeaders;

public class HeaderInitializer {

    public HeaderInitializer() {}

    public HttpHeaders invoke() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Schema", "S2S");
        headers.add("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        headers.add("X-Time-Zone", "Europe/Rome");
        headers.add("Content-Type", "application/json");
        return headers;
    }
}
