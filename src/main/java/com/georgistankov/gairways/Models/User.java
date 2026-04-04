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
    private String Username;

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

    @ManyToMany(mappedBy = "FLIGHTS")
    private List<Flight> Flights;

    @OneToMany(mappedBy = "TICKETS")
    private List<Ticket> Tickets;

}
