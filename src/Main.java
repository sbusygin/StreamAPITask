import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<Person> persons = Arrays.asList(
                new Person("Jack", "Evans", 16, Sex.MAN, Education.SECONDARY),
                new Person("Connor", "Young", 23, Sex.MAN, Education.FURTHER),
                new Person("Emily", "Harris", 42, Sex.WOMEN, Education.HIGHER),
                new Person("Harry", "Wilson", 69, Sex.MAN, Education.HIGHER),
                new Person("George", "Davies", 35, Sex.MAN, Education.FURTHER),
                new Person("Samuel", "Adamson", 40, Sex.MAN, Education.HIGHER),
                new Person("John", "Brown", 44, Sex.MAN, Education.HIGHER)
        );

        System.out.println(persons.stream()
                .filter(person -> person.getAge() < 18)
                .count());

        System.out.println(persons.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 29)
                .filter(person -> person.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList()));

        System.out.println(persons.stream()
                .filter(person -> person.getAge() > 18 && (person.getAge() < 65 && person.getSex() == Sex.MAN) || (person.getAge() < 60 && person.getSex() == Sex.WOMEN))
                .filter(person -> person.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList()));
    }
}
