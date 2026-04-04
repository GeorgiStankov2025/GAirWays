package com.georgistankov.gairways.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="PLANES")
public class Plane {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="PLANE_ID")
    private UUID PlaneId;

    @Column(name="PLANE_MODEL")
    private String PlaneModel;

    @Column(name="ECONOMY_CAPACITY")
    private int EconomyCapacity;

    @Column(name ="BUSINESS_CAPACITY")
    private int BusinessCapacity;

    @OneToMany(mappedBy = "FLIGHTS")
    private List<Flight> Flights;

    public UUID getPlaneId() {
        return PlaneId;
    }

    public void setPlaneId(UUID planeId) {
        PlaneId = planeId;
    }

    public String getPlaneModel() {
        return PlaneModel;
    }

    public void setPlaneModel(String planeModel) {
        PlaneModel = planeModel;
    }

    public int getEconomyCapacity() {
        return EconomyCapacity;
    }

    public void setEconomyCapacity(int economyCapacity) {
        EconomyCapacity = economyCapacity;
    }

    public int getBusinessCapacity() {
        return BusinessCapacity;
    }

    public void setBusinessCapacity(int businessCapacity) {
        BusinessCapacity = businessCapacity;
    }

    public List<Flight> getFlights() {
        return Flights;
    }

    public void setFlights(List<Flight> flights) {
        Flights = flights;
    }
}
