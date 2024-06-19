package com.servicedto.techiteasy.dtos.inputs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RemoteControllerInputDto {
    public Long id;
    @NotNull
    public String compatibleWith;
    @NotBlank
    public String batteryType;
    @NotBlank
    public String name;
    @NotBlank
    public String brand;
    @Positive
    public double price;
    @NotNull
    public int originalStock;
}
