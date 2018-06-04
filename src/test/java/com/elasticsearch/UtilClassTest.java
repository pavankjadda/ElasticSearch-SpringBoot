package com.elasticsearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
public class UtilClassTest
{

    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect()
    {
        Optional<String>    opt=Optional.of("john");
        opt.ifPresent(new Consumer<String>()
        {
            @Override
            public void accept(String name)
            {
                System.out.println("name-> "+name);
            }
        });
    }

    @Test
    public void inheritanceTest()
    {
        //Car is a vehicle, but every vehicle is not a car.
        Vehicle vehicle=new Car();
        vehicle.setId("car1001");
        vehicle.setNumberOfWheels("4");
        System.out.println("vehicle-> "+vehicle.getId());
        System.out.println("vehicle.getClass()"+vehicle.getClass());

        List<Vehicle>   vehicles=new ArrayList<>();
        vehicles.add(new Car("1000","Camry","SE"));
        vehicles.add(new Truck("10000","GM","80000"));
        System.out.println("vehicles.get(0).getClass()-> "+vehicles.get(0).getClass());
        System.out.println("vehicles.get(1).getClass()-> "+vehicles.get(1).getClass());
        System.out.println(vehicles);

    }
}
