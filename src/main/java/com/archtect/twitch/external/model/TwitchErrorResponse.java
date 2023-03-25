package com.archtect.twitch.external.model;

public record TwitchErrorResponse(
        String message,
        String error,
        String details
) {
}
