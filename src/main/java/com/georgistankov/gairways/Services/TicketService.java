package com.georgistankov.gairways.Services;

import com.georgistankov.gairways.Exceptions.ResourceNotFoundException;
import com.georgistankov.gairways.Models.Flight;
import com.georgistankov.gairways.Models.Plane;
import com.georgistankov.gairways.Models.Ticket;
import com.georgistankov.gairways.Models.User;
import com.georgistankov.gairways.Repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final FlightService flightService;
    private final UserService userService;

    public TicketService(TicketRepository ticketRepository,
                         FlightService flightService,
                         UserService userService)
    {
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;
        this.userService = userService;
    }

    public Ticket createTicket()
    {

        String currentUserUsername= userService.getCurrentUserUsername();
        User user=userService.getUserByUsername(currentUserUsername);
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
        return ticketRepository.findById(ticketId).orElseThrow(
                ()->new ResourceNotFoundException("No ticket found with this id."));
    }

    public String deleteTicket(UUID ticketId)
    {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(
                ()->new ResourceNotFoundException("Cannot delete. No ticket found with this id."));
        ticketRepository.delete(ticket);
        return "Ticket has been deleted";
    }

    public Ticket addFlight(UUID ticketId, UUID flightId)
    {

        Ticket ticket=getTicketById(ticketId);
        Flight flight=flightService.getFlight(flightId);
        ticket.getFlights().add(flight);
        ticketRepository.saveAndFlush(ticket);
        ticket.setFinalPrice(calculatePrice(ticket.getFlights()));
        ticketRepository.saveAndFlush(ticket);
        return ticket;

    }

    public BigDecimal calculatePrice(List<Flight> flights)
    {

        String CurrentUserUsername=userService.getCurrentUserUsername();
        User user=userService.getUserByUsername(CurrentUserUsername);

        BigDecimal finalPrice=BigDecimal.ZERO;

        for(Flight flight:flights)
        {

            if(flight.getBusinessPassengers().contains(user)) {

                finalPrice=finalPrice.add(flight.getPrice().add(flight.getPrice().divide(BigDecimal.TEN)));

            }
            else if (flight.getEconomyPassengers().contains(user))
            {
                finalPrice=finalPrice.add(flight.getPrice());
            }

        }

        return finalPrice;

    }



}
