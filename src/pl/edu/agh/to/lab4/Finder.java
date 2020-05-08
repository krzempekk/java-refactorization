package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Finder {
    PersonDataProvider personDataProvider;
    PrisonersDatabase prisonersDatabase;

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this.prisonersDatabase = prisonersDatabase;
        this.personDataProvider = personDataProvider;
    }

    public void displayAllSuspectsWithName(String name, int age) {
        CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy();
        searchStrategy.addStrategy(new NameSearchStrategy(name));
        searchStrategy.addStrategy(new AgeSearchStrategy(age));

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
