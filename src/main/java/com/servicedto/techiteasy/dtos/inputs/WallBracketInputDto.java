package com.servicedto.techiteasy.dtos.inputs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class WallBracketInputDto {
    public Long id;
    @NotBlank
    public String size;
    public boolean adjustable;
    @NotBlank
    public String name;
    @Positive
    public double price;


}
