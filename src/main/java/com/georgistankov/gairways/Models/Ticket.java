package com.georgistankov.gairways.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="TICKETS")
public class Ticket {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="TICKET_ID")
    private UUID TicketId;

    @ManyToOne
    @JoinColumn(name="FLIGHT_ID")
    private Flight Flight;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User User;

}
