package com.yahyabaassou.java8.examples;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LiveCodingLambda {


    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>(
                Arrays.asList(
                        new Country("Singapore", "Singapore", 5.639),
                        new Country("Malaysia", "Kuala Lumpur", 31.53),
                        new Country("Thailand", "Bangkok", 69.43),
                        new Country("Indonesia", "Jakarta", 267.7),
                        new Country("Vietnam", "Ho Chi Minh", 95.54),
                        new Country("Japan", "Tokyo", 126.5),
                        new Country("Philippines", "Manila", 106.7),
                        new Country("Laos", "Vientiane", 7.062),
                        new Country("Cambodia", "Phnom Penh", 16.25),
                        new Country("India", "New Delhi", 1353)
                )
        );

        //with java 8 lambda
        Function<String, String> myFunction = str -> str.toUpperCase();

        //with java 8 method reference
        Function<String, String> myFunction2 = String::toUpperCase;

        System.out.println(myFunction.apply(countries.get(0).name));
        System.out.println(myFunction2.apply(countries.get(0).name));

    }

    private static class Country {
        private String name;
        private String capital;
        private double population; //in millions


        public Country(String name) {
            this.name = name;
            this.capital = null;
            this.population = 0;
        }


        public Country(String name, String capital, double population) {
            this.name = name;
            this.capital = capital;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public String getCapital() {
            return capital;
        }

        public double getPopulation() {
            return population;
        }
    }

}
