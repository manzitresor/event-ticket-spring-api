package com.thegym.eventtickets.domain.dtos;

import com.thegym.eventtickets.enums.EventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateEventRequestDto {
    private String name;
    private LocalDateTime eventStart;
    private LocalDateTime eventEnd;
    private String venue;
    private LocalDateTime salesStart;
    private LocalDateTime salesEndDate;
    private EventStatusEnum status;
}
