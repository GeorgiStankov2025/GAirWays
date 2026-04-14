package com.georgistankov.gairways.Models;

import com.georgistankov.gairways.Enums.UserRole;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="USER_ID")
    private UUID UserId;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PASSWORD_HASH")
    private String PasswordHash;

    @Column(name="EMAIL")
    private String Email;

    @Column(name="CREATED_AT")
    private LocalDateTime CreatedAt;

    @Column(name="MODIFIED_AT")
    private LocalDateTime ModifiedAt;

    @Column(name="USER_ROLE")
    private UserRole UserRole;

    @ManyToMany(mappedBy = "BusinessPassengers")
    private List<Flight> BusinessFlights;

    @ManyToMany(mappedBy = "EconomyPassengers")
    private List<Flight> EconomyFlights;

    @OneToMany(mappedBy = "User")
    private List<Ticket> Tickets;


    public UUID getUserId() {
        return UserId;
    }

    public void setUserId(UUID userId) {
        UserId = userId;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String passwordHash) {
        PasswordHash = passwordHash;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return ModifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        ModifiedAt = modifiedAt;
    }

    public UserRole getUserRole() {
        return UserRole;
    }

    public void setUserRole(UserRole userRole) {
        UserRole = userRole;
    }



    public List<Ticket> getTickets() {
        return Tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        Tickets = tickets;
    }

    public List<Flight> getBusinessFlights() {
        return BusinessFlights;
    }

    public void setBusinessFlights(List<Flight> businessFlights) {
        BusinessFlights = businessFlights;
    }

    public List<Flight> getEconomyFlights() {
        return EconomyFlights;
    }

    public void setEconomyFlights(List<Flight> economyFlights) {
        EconomyFlights = economyFlights;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
