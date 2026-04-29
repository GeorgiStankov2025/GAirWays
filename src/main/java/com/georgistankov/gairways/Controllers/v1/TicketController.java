package com.georgistankov.gairways.Controllers.v1;

import com.georgistankov.gairways.Models.Ticket;
import com.georgistankov.gairways.Services.TicketService;
import com.georgistankov.gairways.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("")
    public Ticket createTicket() {

        return ticketService.createTicket();

    }

    @GetMapping("")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable UUID id) {
        return ticketService.getTicketById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable UUID id) {

        return ticketService.deleteTicket(id);

    }

    @PostMapping("/{id}/flights")
    public Ticket addFlight(@PathVariable UUID id, @RequestHeader UUID flightId)
    {

        return ticketService.addFlight(id, flightId);

    }

}
