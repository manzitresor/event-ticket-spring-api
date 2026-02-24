package com.thegym.eventtickets.dtos;

import com.thegym.eventtickets.domain.User;
import com.thegym.eventtickets.enums.EventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {
    private String name;
    private String description;
    private LocalDateTime eventStart;
    private LocalDateTime eventEnd;
    private String venue;
    private LocalDateTime salesStart;
    private LocalDateTime salesEndDate;
    private EventStatusEnum status;
    private User organizer;
}
