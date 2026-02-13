package com.thegym.eventtickets.domain;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(unique = true, nullable = false,updatable = false)
    private UUID id;

    @Column(name = "name", unique = true, nullable = false,updatable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "organizer")
    @JoinColumn()
    private List<Event> organizedEvents = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_attending_events",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> attendingEvents = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "user_staffing_events",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> staffingEvents = new ArrayList<>();

    @OneToMany(mappedBy = "purchaser")
    private List<Ticket> tickets = new ArrayList<>();



    @CreatedDate
    @Column(name ="created_at", nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at",nullable = false,updatable = true)
    private LocalDateTime updatedAt;
}
