package com.yahyabaassou.java8.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LiveCoding {


    private static final List<Country> COUNTRIES = Arrays.asList(
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
    );

    public static void main(String[] args) {
        System.out.println(sortWithJava7());
        System.out.println(sortWithJava8());
    }

    //Get a list of String that contains "Country:Capital" for the top 3 countries
    public static List<String> sortWithJava7() {
        Collections.sort(COUNTRIES, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return Double.compare(o2.getPopulation(), o1.getPopulation());
            }
        });

        Country firstOne = COUNTRIES.get(0);
        Country secondOne = COUNTRIES.get(1);
        Country thirdOne = COUNTRIES.get(2);

        return Arrays.asList(
                firstOne.getName().concat(":").concat(firstOne.getCapital()),
                secondOne.getName().concat(":").concat(secondOne.getCapital()),
                thirdOne.getName().concat(":").concat(thirdOne.getCapital())
        );
    }


    public static List<String> sortWithJava8() {
        //TODO: to be completed
        return Collections.emptyList();
    }

    private static class Country {
        private String name;
        private String capital;
        private double population; //in millions

        public Country(String name, String capital, double population) {
            this.name = name;
            this.capital = capital;
            this.population = population;
        }

        public String getName() { return name; }
        public String getCapital() { return capital; }
        public double getPopulation() { return population; }
    }

}
