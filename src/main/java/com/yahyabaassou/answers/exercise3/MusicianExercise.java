package com.yahyabaassou.answers.exercise3;


import com.yahyabaassou.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class MusicianExercise {

    private Collection<Person> people;

    public MusicianExercise() {
        this.people = readFileAndReturnPeopleList();
    }

    public Collection<Person> readFileAndReturnPeopleList() {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("musicians.csv");
        if (Objects.isNull(resourceAsStream)) return Collections.emptyList();
        InputStreamReader reader = new InputStreamReader(resourceAsStream);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(reader)) {
            lines = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buildPeopleList(lines);
    }

    private Collection<Person> buildPeopleList(List<String> lines) {
        return lines.stream()
                .map(line -> {
                    String[] columns = line.split(";");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String[] birthParts = columns[3].split(",");
                    String[] deathParts = columns[5].split(",");
                    Date birthDate;
                    Date deathDate;
                    try {
                        birthDate = dateFormat.parse(columns[2]);
                        deathDate = dateFormat.parse(columns[4]);
                    } catch (ParseException e) {
                        throw new IllegalArgumentException(e);
                    }
                    return new Person(columns[0], columns[1], birthDate, birthParts[0], birthParts[1], deathDate, deathParts[0],
                            deathParts[1]);
                })
                .collect(toList());
    }

    /**
     * Print the musicians list to the console to verify that everything is working fine
     *
     * @param console Console object to be use to print the result
     */
    public void printToGivenConsole(PrintStream console) {
        people.forEach(console::println);
    }

    /**
     * Get list of all birth countries (should not contains duplicate elements)
     * (use people list)
     */
    public Collection<String> getBirthCountries() {
        return people.stream()
                .map(Person::getBirthCountry)
                .sorted()
                .distinct()
                .collect(toList());
    }

    /**
     * Print last name and first name of each musician order by last name then first name to the Given console
     * (use people list)
     *
     * @param console La console à utiliser pour l'affichage
     */
    public void printLastAndFirstNameInOrder(PrintStream console) {
        people.stream()
                .sorted(comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .forEachOrdered(console::println);
    }

    /**
     * Count musicians with last name contains letter B (the case doesn't matter)
     * (use people list)
     */
    public long numberOfMusicians() {
        return people.stream()
                .map(Person::getLastName)
                .map(String::toUpperCase)
                .filter(lastName -> lastName.contains("B"))
                .count();
    }

    /**
     * Group all musicians according their [birth country, death country]
     * (use people list)
     */
    public Map<List<String>, Set<String>> musiciansByCountries() {
        Function<Person, List<String>> countriesOfBirthAndDeath =
                person -> asList(person.getBirthCountry(), person.getDeathCountry());

        return people.stream()
                .collect(groupingBy(countriesOfBirthAndDeath, mapping(Person::toString, toSet())));
    }

}
