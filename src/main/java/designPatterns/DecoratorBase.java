package designPatterns;

public class DecoratorBase implements Decoratable {

    @Override
    public void print() {
        System.out.println("Base");
    }
}
