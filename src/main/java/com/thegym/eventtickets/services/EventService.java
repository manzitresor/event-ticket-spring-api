package com.thegym.eventtickets.services;

import com.thegym.eventtickets.domain.Event;
import com.thegym.eventtickets.dtos.CreateEventRequest;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId,CreateEventRequest event);
}
