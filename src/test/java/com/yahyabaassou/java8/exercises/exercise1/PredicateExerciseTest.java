package com.yahyabaassou.java8.exercises.exercise1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;


public class PredicateExerciseTest {

    private PredicateExercise predicateExercise;

    @Before
    public void setup() {
        predicateExercise = new PredicateExercise();
    }

    @Test
    public void getFastestModelShouldReturnExpectedValue() {
        //GIVEN
        List<String> expectedValues = Arrays.asList("Honda", "Lexus", "Mazda");

        //WHEN
        List<String> brands = predicateExercise.getMatchingBrands();

        //THEN
        assertThat(brands, hasSize(3));
        assertThat(brands, equalTo(expectedValues));

    }


}
