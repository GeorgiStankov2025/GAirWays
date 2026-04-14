package com.georgistankov.gairways.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightDTO {

    @NotBlank(message = "No Departure provided")
    @Size(min = 3, max = 20, message = "The size must be between 3 and 20 letters")
    private String Departure;

    @NotBlank(message = "No Destination provided")
    @Size(min = 3, max = 20, message = "The size must be between 3 and 20 letters")
    private String Destination;

    @NotBlank(message = "No Departure time provided")
    private LocalDateTime DepartureTime;

    @NotBlank(message = "No Arrival time provided")
    private LocalDateTime ArrivalTime;

    @NotBlank(message = "No Destination provided")
    @Size(min = 1, message = "Price must be bigger than 0")
    @NumberFormat(style=NumberFormat.Style.CURRENCY)
    private BigDecimal Price;

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

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }
}
