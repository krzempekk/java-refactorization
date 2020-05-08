package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;

public class Finder {
    CompositeAggregate compositeAggregate;

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
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
            Suspect suspect = it.next();
            if(searchStrategy.filter(suspect) && suspect.canBeSuspect()) {
                suspectedPeople.add(suspect);
            }
        }

        System.out.println("Znalazlem " + suspectedPeople.size() + " pasujacych podejrzanych!");

        for (Suspect suspect: suspectedPeople) {
            System.out.println(suspect.getFullName());
        }
    }
}
