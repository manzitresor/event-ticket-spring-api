package com.thegym.eventtickets.domain;

import com.thegym.eventtickets.enums.TicketStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tickets")
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id",nullable = false, updatable = false)
    private UUID id;

    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_type_id")
    private TicketType ticketType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchaser_id")
    private User purchaser;

    @OneToMany(mappedBy = "ticket",fetch = FetchType.LAZY)
    private List<TicketValidation> ticketValidations = new ArrayList<>();

    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
    private List<QrCode> qrCodes = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
