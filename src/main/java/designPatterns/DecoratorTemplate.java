package designPatterns;

public class DecoratorTemplate implements Decoratable {

    private final Decoratable decoratable;

    public DecoratorTemplate(final Decoratable decoratable) {
        this.decoratable = decoratable;
    }

    @Override
    public void print() {
        decoratable.print();
    }
}
