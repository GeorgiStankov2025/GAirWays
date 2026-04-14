package com.georgistankov.gairways.Services;

import com.georgistankov.gairways.Models.Plane;
import com.georgistankov.gairways.Models.Ticket;
import com.georgistankov.gairways.Models.User;
import com.georgistankov.gairways.Repositories.TicketRepository;

import java.util.List;
import java.util.UUID;

public class TicketService {

    private final TicketRepository ticketRepository;
    private final FlightService flightService;
    private final UserService userService;

    public TicketService(TicketRepository ticketRepository,
                         FlightService flightService,
                         TicketRepository ticketRepository1,
                         FlightService flightService1,
                         UserService userService)
    {
        this.ticketRepository = ticketRepository1;
        this.flightService = flightService1;
        this.userService = userService;
    }

    public Ticket createTicket(UUID userId)
    {

        User user= userService.getUser(userId);

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticketRepository.saveAndFlush(ticket);
        return ticket;

    }

    public List<Ticket> getAllTickets()
    {

        return ticketRepository.findAll();

    }

    public Ticket getTicketById(UUID ticketId)
    {
        return ticketRepository.findById(ticketId).get();
    }

    public String deleteTicket(UUID ticketId)
    {
        Ticket ticket = ticketRepository.findById(ticketId).get();
        ticketRepository.delete(ticket);
        return "Ticket has been deleted";
    }


}
