package pl.edu.agh.to.lab4;

import java.util.Iterator;

public class Application {

    public static void main(String[] args) {
        for (Iterator<Suspect> it = new PersonDataProvider().iterator(); it.hasNext(); ) {
            Suspect s = it.next();
            System.out.println(s.getFullName());
        }
//        Finder suspects = new Finder(new PersonDataProvider(), new PrisonersDatabase());
//        suspects.displayAllSuspectsWithName("Janusz");
    }
}
