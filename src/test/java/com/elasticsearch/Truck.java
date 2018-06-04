package com.elasticsearch;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Truck  extends Vehicle
{
    public String   horsePower;

    public String   model;

    public String   maxLoad;

    public Truck()
    {
    }

    public Truck(String horsePower, String model, String maxLoad)
    {
        this.horsePower = horsePower;
        this.model = model;
        this.maxLoad = maxLoad;
    }
}
