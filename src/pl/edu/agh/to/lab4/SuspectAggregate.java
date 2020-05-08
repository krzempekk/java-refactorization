package pl.edu.agh.to.lab4;

<<<<<<< HEAD
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class SuspectAggregate {
    private final Collection<Person> allPersons;

    private final Map<String, Collection<Prisoner>> allPrisons;

    public SuspectAggregate( Collection<Person> persons, Map<String, Collection<Prisoner>> prisoners) {
        allPersons = persons;
        allPrisons = prisoners;
    }

    public Iterator<Suspect> iterator() {
        

    }
=======
import java.util.Iterator;

public interface SuspectAggregate {
    Iterator<Suspect> iterator();
>>>>>>> 81eccf0ce55becd4591ed9fefc86a3172cd1ab7d
}
