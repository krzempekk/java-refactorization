package pl.edu.agh.to.lab4;

public abstract class Suspect {
    private String firstName;
    private String surName;
    private int age;

    Suspect(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.surName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
