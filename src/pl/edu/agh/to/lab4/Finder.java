package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Finder {
    private final Collection<Person> allPersons;

    private final Map<String, Collection<Prisoner>> allPrisons;

    public Finder(Collection<Person> allPersons, Map<String, Collection<Prisoner>> allPrisons) {
        this.allPersons = allPersons;
        this.allPrisons = allPrisons;
    }

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this(personDataProvider.getAllCracowCitizens(), prisonersDatabase.findAll());
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Prisoner> suspectedPrisoners = new ArrayList<Prisoner>();
        ArrayList<Person> suspectedPersons = new ArrayList<Person>();

        for (Collection<Prisoner> prisonerCollection: allPrisons.values()) {
            for (Prisoner prisoner: prisonerCollection) {
                if (prisoner.canBeSuspect() && prisoner.name.equals(name)) {
                    suspectedPrisoners.add(prisoner);
                }
            }
        }

        for (Person person : allPersons) {
            if (person.getAge() > 18 && person.getFirstname().equals(name)) {
                suspectedPersons.add(person);
            }
        }

        int suspectsCount = suspectedPrisoners.size() + suspectedPersons.size();
        System.out.println("Znalazlem " + suspectsCount + " pasujacych podejrzanych!");

        for (Prisoner prisoner: suspectedPrisoners) {
            System.out.println(prisoner.getFullname());
        }

        for (Person person: suspectedPersons) {
            System.out.println(person.getFullname());
        }
    }
}
