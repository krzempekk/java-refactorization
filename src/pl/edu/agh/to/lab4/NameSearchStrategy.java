package pl.edu.agh.to.lab4;

public class NameSearchStrategy implements SearchStrategy {
    String name;

    public NameSearchStrategy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getFirstName().equals(this.name);
    }
}
