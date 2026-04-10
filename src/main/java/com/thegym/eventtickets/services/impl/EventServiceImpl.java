package com.thegym.eventtickets.services.impl;

import com.thegym.eventtickets.domain.Event;
import com.thegym.eventtickets.domain.TicketType;
import com.thegym.eventtickets.domain.User;
import com.thegym.eventtickets.dtos.CreateEventRequest;
import com.thegym.eventtickets.exceptions.UserNotFoundException;
import com.thegym.eventtickets.repositories.UserRepository;
import com.thegym.eventtickets.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final UserRepository userRepository;
    @Override
    public Event createEvent(UUID organizerId, CreateEventRequest event) {
        User organizer = userRepository.findById(organizerId).orElseThrow(()-> new UserNotFoundException("User not found"));

        List<TicketType> ticketTypesToCreate=  event.getTicketTypes().stream().map(ticketType -> {
            TicketType tickectToCreate = new TicketType();
            tickectToCreate.setName(ticketType.getName());
            tickectToCreate.setPrice(ticketType.getPrice());
            tickectToCreate.setDescription(ticketType.getDescription());
            tickectToCreate.setTotalAvailable(ticketType.getTotalAvailable());
            return tickectToCreate;
        }).toList();


        Event eventToCreate = new Event();
        eventToCreate.setName(event.getName());
        eventToCreate.setEventStart(event.getEventStart());
        eventToCreate.setEventEnd(event.getEventEnd());
        eventToCreate.setVenue(event.getVenue());
        eventToCreate.setSalesStart(event.getSalesStart());
        eventToCreate.setSalesEndDate(event.getSalesEndDate());
        eventToCreate.setOrganizer(organizer);
        eventToCreate.setTicketTypes(ticketTypesToCreate);
        return null;
    }
}
