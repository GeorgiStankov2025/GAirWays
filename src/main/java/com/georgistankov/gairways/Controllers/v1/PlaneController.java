package com.georgistankov.gairways.Controllers.v1;

import com.georgistankov.gairways.DTOs.PlaneDTO;
import com.georgistankov.gairways.Models.Plane;
import com.georgistankov.gairways.Services.PlaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/planes")
public class PlaneController {

    private final PlaneService planeService;

    PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @PostMapping("")
    public Plane createPlane(@RequestBody PlaneDTO request) {

        return planeService.addPlane(request);

    }

    @GetMapping("")
    public List<Plane> getPlanes() {
        return planeService.getAllPlanes();
    }

    @GetMapping("/{id}")
    public Plane getPlaneById(@PathVariable UUID id) {

        return planeService.getPlaneById(id);

    }

    @DeleteMapping("/{id}")
    public String deletePlane(@PathVariable UUID id) {

        return planeService.deletePlane(id);

    }

}
