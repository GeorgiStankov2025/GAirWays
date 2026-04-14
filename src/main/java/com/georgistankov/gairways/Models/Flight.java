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

    public UUID getFlightId() {
        return FlightId;
    }

    public void setFlightId(UUID flightId) {
        FlightId = flightId;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        DepartureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public int getEstimatedTime() {
        return EstimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        EstimatedTime = estimatedTime;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public List<User> getEconomyPassengers() {
        return EconomyPassengers;
    }

    public void setEconomyPassengers(List<User> economyPassengers) {
        EconomyPassengers = economyPassengers;
    }

    public List<User> getBusinessPassengers() {
        return BusinessPassengers;
    }

    public void setBusinessPassengers(List<User> businessPassengers) {
        BusinessPassengers = businessPassengers;
    }

    public Plane getPlane() {
        return Plane;
    }

    public void setPlane(Plane plane) {
        Plane = plane;
    }
}
