package com.servicedto.techiteasy.dtos.inputs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class TelevisionInputDto {
    public Long id;
    @NotBlank
    //make constraint for uniqueness here
    public String type;
    @NotBlank
    public String brand;
    @NotBlank
    public String name;
    @Positive
    public double price;
    @Positive
    public double availableSize;
    @Positive
    public double refreshRate;
    @NotBlank
    public String screenType;
    @NotBlank
    public String screenQuality;
    public boolean smartTv;
    public boolean wifi;
    public boolean voiceControl;
    public boolean hdr;
    public boolean bluetooth;
    public boolean ambiLight;
    @NotNull
    public Integer originalStock;
    @PositiveOrZero
    public Integer sold;

}
