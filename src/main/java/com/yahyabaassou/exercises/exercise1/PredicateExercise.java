package com.yahyabaassou.exercises.exercise1;

import com.yahyabaassou.exercises.Exercise;
import com.yahyabaassou.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PredicateExercise {

    private static final List<Car> CARS = new ArrayList<>(Arrays.asList(
            new Car("Honda", "Accord", 190, "Japan"),
            new Car("Lexus", "Rx 350", 200, "Japan"),
            new Car("Mazda", "6", 205, "Japan"),
            new Car("Toyota", "Corolla", 180, "Japan"),
            new Car("Proton", "X70", 180, "Malaysia"),
            new Car("Hyundai", "i20", 170, "South Korea"),
            new Car("Kia", "Ceed", 210, "South Korea"),
            new Car("Renault", "Captur", 192, "France"),
            new Car("Peugeot", "308", 254, "France"),
            new Car("Citroen", "C4", 190, "France")
    ));


    //Use stream to return only brands where the brand name length is > 3 and <= 5 and country is japan or france
    public List<String> getMatchingBrands() {
        return Exercise.replaceThisWithSolution();
    }


}
