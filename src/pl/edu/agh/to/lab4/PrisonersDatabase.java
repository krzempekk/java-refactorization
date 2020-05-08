package pl.edu.agh.to.lab4;

import java.util.*;

public class PrisonersDatabase {

    private final Map<String, Collection<Prisoner>> prisons = new HashMap<>();

    public PrisonersDatabase() {
        addPrisoner("Wiezienie krakowskie", new Prisoner("Jan", "Kowalski", "87080452357", 2005, 7));
        addPrisoner("Wiezienie krakowskie", new Prisoner("Anita", "Wiercipieta", "84080452357", 2009, 3));
        addPrisoner("Wiezienie krakowskie", new Prisoner("Janusz", "Zlowieszczy", "92080445657", 2001, 10));
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Janusz", "Zamkniety", "802104543357", 2010, 5));
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Adam", "Future", "880216043357", 2020, 5));
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Zbigniew", "Nienajedzony", "90051452335", 2011, 1));
        addPrisoner("Wiezienie centralne", new Prisoner("Jan", "Przedziwny", "91103145223", 2009, 4));
        addPrisoner("Wiezienie centralne", new Prisoner("Janusz", "Podejrzany", "85121212456", 2012, 1));
    }

    public Map<String, Collection<Prisoner>> findAll() {
        return prisons;
    }

    public Collection<String> getAllPrisons() {
        return prisons.keySet();
    }

    private void addPrisoner(String category, Prisoner prisoner) {
        if (!prisons.containsKey(category))
            prisons.put(category, new ArrayList<>());
        prisons.get(category).add(prisoner);
    }

    public Iterator<Suspect> iterator() {
        return new FlatIterator(this.prisons);
    }
}
