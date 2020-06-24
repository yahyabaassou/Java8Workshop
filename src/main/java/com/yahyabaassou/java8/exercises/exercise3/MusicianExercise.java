package com.yahyabaassou.java8.exercises.exercise3;

import com.yahyabaassou.java8.exercises.Exercise;
import com.yahyabaassou.java8.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MusicianExercise {

    private Collection<Person> people;

    public MusicianExercise() {
        this.people = readFileAndReturnPeopleList();
    }

    public Collection<Person> readFileAndReturnPeopleList() {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("musicians.csv");
        if (Objects.isNull(resourceAsStream)) return Collections.emptyList();
        InputStreamReader reader = new InputStreamReader(resourceAsStream);
        try (BufferedReader br = new BufferedReader(reader)) {
            List<String> lines = br.lines().collect(Collectors.toList());
            return buildPeopleList(lines);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    /**
     * Build a list of Person from a list of line
     *
     * @param lines all lines from the csv file
     */
    private Collection<Person> buildPeopleList(List<String> lines) {
        return Exercise.replaceThisWithSolution();
    }

    /**
     * Print the musicians list to the console to verify that everything is working fine
     * (use people list)
     *
     * @param console Console object to be use to print the result
     */
    public void printToGivenConsole(PrintStream console) {
        Exercise.replaceThisWithSolution();
    }

    /**
     * Get list of all birth countries (should not contains duplicate elements)
     * (use people list)
     */
    public Collection<String> getBirthCountries() {
        return Exercise.replaceThisWithSolution();
    }

    /**
     * Print last name and first name of each musician order by last name then first name to the Given console
     * (use people list)
     *
     * @param console La console à utiliser pour l'affichage
     */
    public void printLastAndFirstNameInOrder(PrintStream console) {
        Exercise.replaceThisWithSolution();
    }

    /**
     * Count musicians with last name contains letter B (the case doesn't matter)
     * (use people list)
     */
    public long numberOfMusicians() {
        return Exercise.replaceThisWithSolution();
    }

    /**
     * Group all musicians according their [birth country, death country]
     * (use people list)
     */
    public Map<List<String>, Set<String>> getMusiciansByCountries() {
        return Exercise.replaceThisWithSolution();
    }


}
