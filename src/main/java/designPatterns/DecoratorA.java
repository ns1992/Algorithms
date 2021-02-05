package designPatterns;

public class DecoratorA extends DecoratorTemplate{

    public DecoratorA(final Decoratable decoratable) {
        super(decoratable);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("DecoratorA");
    }
}
