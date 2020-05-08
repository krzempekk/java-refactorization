package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeAggregate implements SuspectAggregate {
    ArrayList<SuspectAggregate> providersList;

    CompositeAggregate()
    {
        providersList = new ArrayList<SuspectAggregate>();
    }

    public void add(SuspectAggregate prov) {
        providersList.add(prov);
    }

    private class InternalIterator implements java.util.Iterator<Suspect> {
        private Iterator<SuspectAggregate> currentProvider;
        private Iterator<Suspect> currentSuspect;

        InternalIterator(ArrayList<SuspectAggregate> providers) {
            currentProvider = providers.iterator();
            currentSuspect = currentProvider.next().iterator();
        }

        @Override
        public boolean hasNext() {
            return this.currentProvider.hasNext() || this.currentSuspect.hasNext();
        }

        @Override
        public Suspect next() {
            if (!currentSuspect.hasNext() && currentProvider.hasNext())
                currentSuspect = currentProvider.next().iterator();
            return currentSuspect.next();

        }
    }

    public Iterator<Suspect> iterator() {
        return new InternalIterator(providersList);
    }
}
