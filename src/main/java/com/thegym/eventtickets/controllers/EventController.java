package com.thegym.eventtickets.controllers;


import com.thegym.eventtickets.domain.CreateEventRequest;
import com.thegym.eventtickets.domain.dtos.CreateEventRequestDto;
import com.thegym.eventtickets.domain.dtos.CreateEventResponseDto;
import com.thegym.eventtickets.domain.entities.Event;
import com.thegym.eventtickets.mappers.EventMapper;
import com.thegym.eventtickets.services.EventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping
@AllArgsConstructor
public class EventController {

    private final EventMapper eventMapper;
    private final EventService eventService;

    @PostMapping("/events")
    public ResponseEntity<CreateEventResponseDto> createEvent(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateEventRequestDto createEventRequestDto
            ) {

        CreateEventRequest createEventRequest = eventMapper.fromDto(createEventRequestDto);
        UUID userId = UUID.fromString(jwt.getSubject());
        Event createdEvent = eventService.createEvent(userId, createEventRequest);
        CreateEventResponseDto responseDto = eventMapper.toDto(createdEvent);
        return ResponseEntity.ok(responseDto);

    }
}
