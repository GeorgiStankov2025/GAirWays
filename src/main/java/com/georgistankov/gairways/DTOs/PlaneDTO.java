package com.georgistankov.gairways.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PlaneDTO {

    @NotBlank(message = "No Plane model provided")
    @Size(min = 3, max = 20, message = "The size must be between 3 and 20 letters")
    private String PlaneModel;

    @NotBlank(message = "No Economy capacity provided")
    @Size(min = 1, message = "The capacity for passengers must be more than one.")
    private int EconomyCapacity;

    @NotBlank(message = "No Business capacity provided")
    @Size(min = 1, message = "The capacity for passengers must be more than one.")
    private int BusinessCapacity;


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
}
