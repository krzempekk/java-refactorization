package pl.edu.agh.to.lab4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class FlatIterator implements Iterator<Suspect> {
    private final Iterator<Collection<Prisoner>> currentCollection;
    private Iterator<Prisoner> currentSuspect;

    public FlatIterator(Map<String, Collection<Prisoner>> map) {
        this.currentCollection = map.values().iterator();
        this.currentSuspect = this.currentCollection.next().iterator();
    }

    @Override
    public boolean hasNext() {
        return this.currentCollection.hasNext() || this.currentSuspect.hasNext();
    }

    @Override
    public Suspect next() {
        if(!this.currentSuspect.hasNext()) {
            this.currentSuspect = this.currentCollection.next().iterator();
        }
        return this.currentSuspect.next();
    }
}
