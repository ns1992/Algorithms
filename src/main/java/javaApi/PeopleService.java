package javaApi;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleService {
    public final Map<Boolean, List<Person>> sortInsuranceStatus(final List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(this::isInsurable));
    }

    public final List<Person> getHairColour(final List<Person> people, final Color hairColour) {
        return new ArrayList<>(people.stream()
                .collect(Collectors.groupingBy(Person::getHairColour))
                .get(hairColour));
    }


    public final List<Person> sortByNameThenAge(final List<Person> people) {
        final ArrayList<Person> clone = new ArrayList<>(people);
        clone.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        return clone;
    }

    private boolean isInsurable(final Person person) {
        return person.getAge() >= 21 && !person.getName().equals("Alley");
    }
}
