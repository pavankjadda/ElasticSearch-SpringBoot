package com.elasticsearch;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Car    extends Vehicle
{
    public String   horsePower;

    public String   model;

    public String variant;

    public Car()
    {
    }

    public Car(String horsePower, String model, String variant)
    {
        this.horsePower = horsePower;
        this.model = model;
        this.variant = variant;
    }
}
