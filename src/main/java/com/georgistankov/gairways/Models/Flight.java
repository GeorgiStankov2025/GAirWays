package com.georgistankov.gairways.Models;

import jakarta.persistence.*;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="FLIGHTS")
public class Flight {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="FLIGHT_ID")
    private UUID FlightId;

    @Column(name="DEPARTURE")
    private String Departure;

    @Column(name="DESTINATION")
    private String Destination;

    @Column(name="DEPARTURE_TIME")
    private LocalDateTime DepartureTime;

    @Column(name="ARRIVAL_TIME")
    private LocalDateTime ArrivalTime;

    @Column(name="ESTIMATED_TIME")
    private int EstimatedTime;

    @NumberFormat(style=NumberFormat.Style.CURRENCY)
    @Column(name="PRICE")
    private BigDecimal Price;

    @ManyToMany
    @JoinTable(name="ECONOMY_USERS_FLIGHTS",
        joinColumns = @JoinColumn(name="FLIGHT_ID"),
        inverseJoinColumns = @JoinColumn(name="USER_ID")
    )
    private List<User> EconomyPassengers;

    @ManyToMany
    @JoinTable(name="BUSINESS_USERS_FLIGHTS",
            joinColumns = @JoinColumn(name="FLIGHT_ID"),
            inverseJoinColumns = @JoinColumn(name="USER_ID")
    )
    private List<User> BusinessPassengers;

    @ManyToOne
    @JoinColumn(name="PLANE_ID")
    private Plane Plane;

}
