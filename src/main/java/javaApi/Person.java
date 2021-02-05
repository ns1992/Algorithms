package javaApi;

import java.awt.Color;
import java.util.Objects;

public class Person {

    private String name;
    private Color hairColour;
    private int age;

    public Person(final String name, final Color hairColour, final int age) {
        this.name = name;
        this.hairColour = hairColour;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Color getHairColour() {
        return hairColour;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(hairColour, person.hairColour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hairColour, age);
    }

    @Override
    public String toString() {
        return name + " " + age + " " + hairColour.toString();
    }
}
