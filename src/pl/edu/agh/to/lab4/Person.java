package pl.edu.agh.to.lab4;

public class Person {
    private final String firstname;

    private final String lastname;

    private final int age;

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getFirstname() { return firstname; }

    public String getLastname() { return lastname; }

    public String getFullname() { return firstname + " " + lastname; }

    public int getAge() { return age; }
}
