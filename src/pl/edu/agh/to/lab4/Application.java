package pl.edu.agh.to.lab4;

import java.util.Iterator;

public class Application {

    public static void main(String[] args) {
        Finder suspects = new Finder(new PersonDataProvider(), new PrisonersDatabase());
        suspects.displayAllSuspectsWithName("Janusz");
    }
}
