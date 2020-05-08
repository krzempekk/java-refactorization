package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Finder {

    private final Collection<Person> allPersons;

    private final Map<String, Collection<Prisoner>> allPrisons;


    CompositeAggregate compositeAggregate;


    public Finder(Collection<Person> allPersons, Map<String, Collection<Prisoner>> allPrisons) {
        this.allPersons = allPersons;
        this.allPrisons = allPrisons;
        this.compositeAggregate = null;
    }

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this(personDataProvider.getAllCracowCitizens(), prisonersDatabase.findAll());
        this.compositeAggregate = new CompositeAggregate();
        this.compositeAggregate.add(personDataProvider);
        this.compositeAggregate.add(prisonersDatabase);
    }

    public void displayAllSuspectsWithName(String name, int age) {
        CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy();
        searchStrategy.addStrategy(new NameSearchStrategy(name));
        searchStrategy.addStrategy(new AgeSearchStrategy(age));

        ArrayList<Suspect> suspectedPeople = new ArrayList<Suspect>();


        for (Iterator<Suspect> it = compositeAggregate.iterator(); it.hasNext();) {
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
