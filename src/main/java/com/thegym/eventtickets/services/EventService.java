package com.thegym.eventtickets.services;

import com.thegym.eventtickets.domain.entities.Event;
import com.thegym.eventtickets.domain.CreateEventRequest;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId,CreateEventRequest event);
}
