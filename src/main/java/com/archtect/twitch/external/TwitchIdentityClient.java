package com.archtect.twitch.external;

import com.archtect.twitch.external.model.TwitchToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;


public interface TwitchIdentityClient {

    @PostExchange(url = "/oauth2/token", contentType = "application/x-www-form-urlencoded")
    TwitchToken requestAccessToken(@RequestParam("client_id") String clientId,
                                   @RequestParam("client_secret") String clientSecret,
                                   @RequestParam("grant_type") String grantType);

}
