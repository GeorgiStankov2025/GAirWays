package com.georgistankov.gairways.Repositories;

import com.georgistankov.gairways.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface FlightRepository extends JpaRepository<Flight, UUID> {

}
