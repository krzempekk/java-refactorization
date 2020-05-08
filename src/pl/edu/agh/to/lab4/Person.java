package pl.edu.agh.to.lab4;

public class Person extends Suspect {

    public Person(String firstname, String lastname, int age) {
        super(firstname, lastname, age);
    }

    public String getFirstname() { return super.getFirstName(); }

    public String getLastname() { return super.getSurName(); }

    public String getFullname() { return super.getFullName(); }

    public int getAge() { return super.getAge(); }
}
