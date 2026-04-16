package com.thegym.eventtickets.mappers;


import com.thegym.eventtickets.domain.CreateEventRequest;
import com.thegym.eventtickets.domain.CreateTicketTypeRequest;
import com.thegym.eventtickets.domain.dtos.CreateEventRequestDto;
import com.thegym.eventtickets.domain.dtos.CreateEventResponseDto;
import com.thegym.eventtickets.domain.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateEventRequest fromDto (CreateEventRequestDto dto);

    CreateTicketTypeRequest fromDto (CreateTicketTypeRequest dto);

    CreateEventResponseDto toDto (Event request);

}
