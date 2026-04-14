package com.georgistankov.gairways.Services;

import com.georgistankov.gairways.DTOs.PlaneDTO;
import com.georgistankov.gairways.Models.Plane;
import com.georgistankov.gairways.Repositories.PlaneRepository;
import com.georgistankov.gairways.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlaneService {

    private final PlaneRepository planeRepository;

    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public Plane addPlane(PlaneDTO request) {

        Plane plane = new Plane();
        plane.setPlaneModel(request.getPlaneModel());
        plane.setBusinessCapacity(request.getBusinessCapacity());
        plane.setEconomyCapacity(request.getEconomyCapacity());
        planeRepository.saveAndFlush(plane);
        return plane;

    }

    public Plane getPlaneById(UUID id) {
        return planeRepository.findById(id).get();
    }

    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    public String deletePlane(UUID id)
    {
        Plane plane = planeRepository.findById(id).get();
        planeRepository.delete(plane);
        return "Plane deleted!";
    }

}
