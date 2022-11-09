import java.util.Optional;
import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private Optional<String> city;

    public PersonBuilder(String surname, OptionalInt age, Optional<String> city) {
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Неверно указан возраст!");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = Optional.of(city);
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Не указано имя!");
        }

        if (surname == null) {
            throw new IllegalStateException("Не указана фамилия!");
        }

        Person person;

        if (age.isPresent()) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }

        if (city.isPresent()) {
            person.setAddress(city.get());
        }

        return person;
    }
}
