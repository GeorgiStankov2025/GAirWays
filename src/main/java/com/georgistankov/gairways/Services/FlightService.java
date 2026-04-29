package com.georgistankov.gairways.Services;

import com.georgistankov.gairways.DTOs.FlightDTO;
import com.georgistankov.gairways.Exceptions.BadRequestException;
import com.georgistankov.gairways.Exceptions.ResourceNotFoundException;
import com.georgistankov.gairways.Models.Flight;
import com.georgistankov.gairways.Models.Plane;
import com.georgistankov.gairways.Models.User;
import com.georgistankov.gairways.Repositories.FlightRepository;
import com.georgistankov.gairways.Repositories.PlaneRepository;
import com.georgistankov.gairways.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final PlaneService planeService;

    public FlightService(FlightRepository flightRepository, PlaneService planeService) {
        this.flightRepository = flightRepository;
        this.planeService = planeService;
    }

    public Flight createFlight(FlightDTO request, UUID planeId){

        Plane plane= planeService.getPlaneById(planeId);
        Flight flight = new Flight();
        flight.setDeparture(request.getDeparture());
        flight.setDestination(request.getDestination());
        flight.setPrice(request.getPrice());
        flight.setArrivalTime(request.getArrivalTime());
        flight.setDepartureTime(request.getDepartureTime());
        flight.setPrice(request.getPrice());
        flight.setPlane(plane);
        flight.setEstimatedTime(request.getArrivalTime().getHour()-request.getDepartureTime().getHour());
        flightRepository.saveAndFlush(flight);
        return flight;

    }

    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }

    public Flight getFlight(UUID id){
        return flightRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No flight with this id found in the database"));

    }

    public String deleteFlight(UUID id){
        Flight flight = flightRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException
                        ("Cannot delete because no flight with this id is found in the database or is already deleted"));;
        flightRepository.delete(flight);
        return "Flight deleted!";
    }

    public User addUserToBusinessPassengers(User user,Flight flight)
    {
        if(flight.getBusinessPassengers().size()<flight.getPlane().getBusinessCapacity()) {
            flight.getBusinessPassengers().add(user);
            flightRepository.saveAndFlush(flight);
            return user;
        }
        else{

            throw new BadRequestException("There are no available seats in business class");

        }
    }

    public User addUserToEconomyPassengers(User user,Flight flight)
    {
        if(flight.getEconomyPassengers().size()<flight.getPlane().getEconomyCapacity()) {
            flight.getEconomyPassengers().add(user);
            flightRepository.saveAndFlush(flight);
            return user;
        }
        else{

            throw new BadRequestException("There are no available seats in economy class");

        }
    }

    public List<User> getBusinessPassengers(UUID id){

        Flight flight=getFlight(id);
        return flight.getBusinessPassengers();

    }

    public List<User> getEconomyPassengers(UUID id){

        Flight flight=getFlight(id);
        return flight.getEconomyPassengers();

    }

}
