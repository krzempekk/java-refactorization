package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Finder {
    private final Collection<Person> allPersons;

    private final Map<String, Collection<Prisoner>> allPrisons;

    PersonDataProvider personDataProvider;
    PrisonersDatabase prisonersDatabase;


    public Finder(Collection<Person> allPersons, Map<String, Collection<Prisoner>> allPrisons) {
        this.allPersons = allPersons;
        this.allPrisons = allPrisons;
        this.personDataProvider = null;
        this.prisonersDatabase = null;
    }

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this(personDataProvider.getAllCracowCitizens(), prisonersDatabase.findAll());
        this.prisonersDatabase = prisonersDatabase;
        this.personDataProvider = personDataProvider;
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Suspect> suspectedPeople = new ArrayList<Suspect>();

        for (Iterator<Suspect> it = personDataProvider.iterator(); it.hasNext();) {
            Suspect person = it.next();
            if (person.canBeSuspect() && person.getFirstName().equals(name)) {
                suspectedPeople.add(person);
            }
        }

        for (Iterator<Suspect> it = prisonersDatabase.iterator(); it.hasNext();) {
            Suspect prisoner = it.next();
            if (!prisoner.canBeSuspect() && prisoner.getFirstName().equals(name)) {
                suspectedPeople.add(prisoner);
            }
        }


        System.out.println("Znalazlem " + suspectedPeople.size() + " pasujacych podejrzanych!");

        for (Suspect suspect: suspectedPeople) {
            System.out.println(suspect.getFullName());
        }

    }
}
