package com.yahyabaassou.exercises.exercise3;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class MusicianExerciseTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private MusicianExercise musicianExercise;

    @Before
    public void setup() {
        outContent.reset();

        musicianExercise = new MusicianExercise();
    }

    @Test
    public void printToGivenConsoleShouldWork() {
        musicianExercise.printToGivenConsole(new PrintStream(outContent));

        assertThat(outContent.toString(), equalTo(
                        "" +
                        "Haendel Georg\n" +
                        "Brahms Johannes\n" +
                        "Chopin Frédéric\n" +
                        "Mozart Wolfgang\n" +
                        "Dvořák Antonin\n" +
                        "Rossini Gioachino\n" +
                        "Haydn Joseph\n" +
                        "Mendelssohn Félix\n" +
                        "Tchaïkovski Piotr\n" +
                        "Liszt Franz\n" +
                        "Salieri Antonio\n" +
                        "Schumann Robert\n" +
                        "Schubert Franz\n" +
                        "Debussy Claude\n" +
                        "Wagner Richard\n" +
                        "Van Beethoven Ludwig\n" +
                        "Strauss Richard\n" +
                        "Strauss Johann\n" +
                        "Vivaldi Antonio\n" +
                        "Verdi Giuseppe\n" +
                        "Bach Jean-Sébastien\n"
        ));
    }

    @Test
    public void getBirthCountriesShouldReturnExpectedResult() {
        Collection<String> answer = musicianExercise.getBirthCountries();

        assertThat(answer, containsInAnyOrder("Germany", "Austria", "France", "Italy", "Poland", "Russia", "Czech Republic"));
    }

    @Test
    public void printLastAndFirstNameInOrderShouldWork() {
        musicianExercise.printLastAndFirstNameInOrder(new PrintStream(outContent));

        assertThat(outContent.toString(),
                equalTo("" +
                        "Bach Jean-Sébastien\n" +
                        "Brahms Johannes\n" +
                        "Chopin Frédéric\n" +
                        "Debussy Claude\n" +
                        "Dvořák Antonin\n" +
                        "Haendel Georg\n" +
                        "Haydn Joseph\n" +
                        "Liszt Franz\n" +
                        "Mendelssohn Félix\n" +
                        "Mozart Wolfgang\n" +
                        "Rossini Gioachino\n" +
                        "Salieri Antonio\n" +
                        "Schubert Franz\n" +
                        "Schumann Robert\n" +
                        "Strauss Johann\n" +
                        "Strauss Richard\n" +
                        "Tchaïkovski Piotr\n" +
                        "Van Beethoven Ludwig\n" +
                        "Verdi Giuseppe\n" +
                        "Vivaldi Antonio\n" +
                        "Wagner Richard\n")
        );
    }

    @Test
    public void numberOfMusiciansWithLetterBShouldReturnExpectedResult() {
        long answer = musicianExercise.numberOfMusicians();

        assertThat(answer, equalTo(5L));
    }

    @Test
    public void getMusiciansByCountriesShouldReturnExpectedResult() {
        Map<List<String>, Set<String>> answer = musicianExercise.getMusiciansByCountries();

        Map<List<String>, Set<String>> expectations = new HashMap<List<String>, Set<String>>() {{
            put(asList("Italy", "France"), asSet("Rossini Gioachino"));
            put(asList("Germany", "UK"), asSet("Haendel Georg"));
            put(asList("Italy", "Italy"), asSet("Verdi Giuseppe"));
            put(asList("Russia", "Russia"), asSet("Tchaïkovski Piotr"));
            put(asList("Germany", "Germany"), asSet("Mendelssohn Félix", "Schumann Robert", "Strauss Richard", "Bach Jean-Sébastien"));
            put(asList("Italy", "Austria"), asSet("Salieri Antonio", "Vivaldi Antonio"));
            put(asList("Austria", "Austria"), asSet("Haydn Joseph", "Schubert Franz", "Strauss Johann"));
            put(asList("Germany", "Austria"), asSet("Brahms Johannes", "Mozart Wolfgang", "Van Beethoven Ludwig"));
            put(asList("Germany", "Italy"), asSet("Wagner Richard"));
            put(asList("France", "France"), asSet("Debussy Claude"));
            put(asList("Poland", "France"), asSet("Chopin Frédéric"));
            put(asList("Czech Republic", "Czech Republic"), asSet("Dvořák Antonin"));
            put(asList("Austria", "Germany"), asSet("Liszt Franz"));
        }};

        assertThat(answer.keySet(), equalTo(expectations.keySet()));

        expectations.forEach((countries, musicians) ->
                assertThat(answer.get(countries), equalTo(expectations.get(countries)))
        );
    }

    private static Set<String> asSet(String... values) {
        return new HashSet<>(asList(values));
    }

}
