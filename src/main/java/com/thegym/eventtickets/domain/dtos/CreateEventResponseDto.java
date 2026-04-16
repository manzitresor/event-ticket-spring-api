package com.thegym.eventtickets.domain.dtos;

import com.thegym.eventtickets.enums.EventStatusEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CreateEventResponseDto {
    private UUID id;
    private LocalDateTime eventStart;
    private LocalDateTime eventEnd;
    private String venue;
    private LocalDateTime salesStart;
    private LocalDateTime salesEnd;
    private EventStatusEnum status;
    private List<CreateEventResponseDto> ticketTypes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
