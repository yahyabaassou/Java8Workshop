package com.yahyabaassou.exercises.exercise2;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class ComparatorExerciseTest {

    private ComparatorExercise comparatorExercise;

    @Before
    public void setup() {
        comparatorExercise = new ComparatorExercise();
    }

    @Test
    public void getFastestModelShouldReturnExpectedValue() {
        //GIVEN
        String expectedValue = "308";

        //WHEN
        String fastestCarModel = comparatorExercise.getFastestCarModel();

        //THEN
        assertThat(fastestCarModel, equalTo(expectedValue));

    }

    @Test
    public void getThe3FastestCountriesShouldReturnExpectedValue() {
        //GIVEN
        String firstCountry = "France";
        String secondCountry = "South Korea";
        String thirdCountry = "Japan";

        //WHEN
        List<String> countries = comparatorExercise.getThe3FastestCountries();

        //THEN
        assertThat(countries, notNullValue());
        assertThat(countries.get(0), equalTo(firstCountry));
        assertThat(countries.get(1), equalTo(secondCountry));
        assertThat(countries.get(2), equalTo(thirdCountry));

    }
}
