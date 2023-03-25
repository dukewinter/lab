package com.archtect.twitch;

import com.archtect.twitch.external.TwitchApiClient;
import com.archtect.twitch.external.TwitchIdentityClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AppConfig {

    @Bean
    public TwitchIdentityClient twitchIdentityClient() {
        WebClient client = WebClient.builder()
                .baseUrl("https://id.twitch.tv/")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(TwitchIdentityClient.class);
    }

    @Bean
    public TwitchApiClient twitchApiClient(@Value("${twitch.client-id}") String twitchClientId) {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.twitch.tv")
                .defaultHeader("Client-Id", twitchClientId)
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(TwitchApiClient.class);
    }
}
