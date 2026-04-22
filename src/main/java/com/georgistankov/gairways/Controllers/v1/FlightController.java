package com.georgistankov.gairways.Controllers.v1;

import com.georgistankov.gairways.DTOs.FlightDTO;
import com.georgistankov.gairways.Models.Flight;
import com.georgistankov.gairways.Services.FlightService;
import com.georgistankov.gairways.Services.PlaneService;
import com.georgistankov.gairways.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    FlightController(FlightService flightService, UserService userService, PlaneService planeService) {
        this.flightService = flightService;
    }

    @PostMapping("")
    public Flight createFlight(@RequestBody FlightDTO request, @RequestHeader UUID planeId)
    {
        return flightService.createFlight(request,planeId);
    }

    @GetMapping("")
    public List<Flight> getFlights()
    {
        return flightService.getFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlight(@PathVariable UUID id)
    {
        return flightService.getFlight(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable UUID id)
    {
        flightService.deleteFlight(id);
    }

}
