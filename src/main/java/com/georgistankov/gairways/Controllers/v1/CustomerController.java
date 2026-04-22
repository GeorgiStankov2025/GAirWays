package com.georgistankov.gairways.Controllers.v1;

import com.georgistankov.gairways.Models.Flight;
import com.georgistankov.gairways.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final UserService userService;

    public CustomerController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/business_flights")
    public Flight addBusinessFlight(@RequestHeader UUID flightId){

        return userService.addBusinessFlight(flightId);

    }

    @PostMapping("/economy_flights")
    public Flight addEconomyFlight(@RequestHeader UUID flightId){

        return userService.addEconomyFlight(flightId);

    }

    @GetMapping("/business_flights")
    public List<Flight> getBusinessFlightsForUser()
    {

        return userService.getBusinessFlightsForUser();

    }

    @GetMapping("/economy_flights")
    public List<Flight> getEconomyFlightsForUser()
    {

        return userService.getEconomyFlightsForUser();

    }

}
