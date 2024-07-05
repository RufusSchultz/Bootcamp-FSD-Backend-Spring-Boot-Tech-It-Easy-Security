package com.servicedto.techiteasy.dtos.inputs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CIModuleInputDto {
    public long id;
    @NotBlank
    public String name;
    @NotBlank
    public String type;
    @Positive
    public double price;
}
