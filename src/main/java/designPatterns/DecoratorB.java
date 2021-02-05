package designPatterns;

public class DecoratorB extends DecoratorTemplate {


    public DecoratorB(final Decoratable decoratable) {
        super(decoratable);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("DecoratorB");
    }
}
