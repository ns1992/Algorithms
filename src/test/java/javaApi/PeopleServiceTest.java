package javaApi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PeopleServiceTest {
    private final PeopleService peopleService = new PeopleService();
    private ArrayList<Person> people;
    private Person aziz;
    private Person alley;
    private Person abbeyTheElder;
    private Person abbeyTheYounger;

    @BeforeEach
    public void setup() {
        people = new ArrayList<>();
        aziz = new Person("Aziz", Color.RED, 35);
        alley = new Person("Alley", Color.BLACK, 30);
        abbeyTheElder = new Person("Abbey", Color.BLACK, 45);
        abbeyTheYounger = new Person("Abbey", Color.BLACK, 18);

        people.add(aziz);
        people.add(alley);
        people.add(abbeyTheElder);
        people.add(abbeyTheYounger);
    }

    @Test
    public void test_whenGroupingByBlackHair_returnsOnlyBlackHair() {
        final List<Person> blackHair = peopleService.getHairColour(people, Color.BLACK);
        assertEquals(Arrays.asList(alley, abbeyTheElder, abbeyTheYounger), blackHair);
    }

    @Test
    public void test_whenComparingByNameThenAge_returnsInOrder() {
        final List<Person> expectedSort = Arrays.asList(abbeyTheYounger, abbeyTheElder, alley, aziz);
        // Java API uses a stable sort for merging.
        // Layering multiple sorts establishes a Lexicographical ordering of the keys
        // where the significance of the subkeys is the reverse order the sorts were applied
        final List<Person> sorted = peopleService.sortByNameThenAge(this.people);
        assertEquals(expectedSort, sorted);

        // Original list unchanged
        assertNotEquals(expectedSort, people);
    }

    @Test
    public void test_groupingByPredicate_returnsGrouped() {
        final Map<Boolean, List<Person>> insuranceStatus = peopleService.sortInsuranceStatus(people);
        assertThat("Are insurable", insuranceStatus.get(Boolean.TRUE), containsInAnyOrder(abbeyTheElder, aziz));
        assertThat("Are NOT insurable", insuranceStatus.get(Boolean.FALSE), containsInAnyOrder(abbeyTheYounger, alley));
    }
}