package designPatterns.adapter;

/**
 * Adapts the third party FrenchPerson interface to be compatible with our Person interface
 */
public class FrenchAdapter implements Person{
    private final FrenchPerson frenchPerson;

    public FrenchAdapter(final FrenchPerson frenchPerson) {
        this.frenchPerson = frenchPerson;
    }

    @Override
    public String getName() {
        return frenchPerson.getNom();
    }

    @Override
    public String getWork() {
        return frenchPerson.getTravail();
    }
}
