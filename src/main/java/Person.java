import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected Optional<String> city;

    public void happyBirthday() {
        age = OptionalInt.of(age.getAsInt() + 1);
    }

    public OptionalInt getAge() {
        return age.stream().findAny();
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return city.isPresent();
    }

    public String getAddress() {
        return city.get();
    }

    public void setAddress(String city) {
        this.city = Optional.of(city);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, OptionalInt age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(surname, OptionalInt.of(0), city);
    }

    @Override
    public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age.getAsInt() +
                    ", city=" + city.get() +
                    '}';
    }
}
