package com.georgistankov.gairways.Models;

import jakarta.persistence.*;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="TICKETS")
public class Ticket {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="TICKET_ID")
    private UUID TicketId;

    @ManyToMany
    @JoinTable(name = "TICKETS_FLIGHTS",
            joinColumns = @JoinColumn(name = "TICKET_ID"),
            inverseJoinColumns = @JoinColumn(name = "FLIGHT_ID"))
    private List<Flight> Flights;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User User;

    @NumberFormat(style=NumberFormat.Style.CURRENCY)
    @Column(name="FINAL_PRICE")
    private BigDecimal FinalPrice;

    public UUID getTicketId() {
        return TicketId;
    }

    public void setTicketId(UUID ticketId) {
        TicketId = ticketId;
    }


    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public List<Flight> getFlights() {
        return Flights;
    }

    public void setFlights(Flight flight) {
        Flights.add(flight);
    }

    public BigDecimal getFinalPrice() {
        return FinalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        FinalPrice=finalPrice;
    }
}
