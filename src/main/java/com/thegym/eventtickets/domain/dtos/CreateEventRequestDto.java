package com.thegym.eventtickets.domain.dtos;

import com.thegym.eventtickets.enums.EventStatusEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateEventRequestDto {
    @NotBlank(message = "Event name is required")
    private String name;

    private LocalDateTime eventStart;
    private LocalDateTime eventEnd;

    @NotBlank(message = "Venue information is required")
    private String venue;
    private LocalDateTime salesStart;
    private LocalDateTime salesEndDate;

    @NotNull(message="Event status is required")
    private EventStatusEnum status;
    @NotEmpty(message="At least one ticket type is required")
    @Valid
    private List<CreateTypeRequestDto> ticketTypes;
}
