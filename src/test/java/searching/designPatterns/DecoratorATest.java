package searching.designPatterns;

import designPatterns.DecoratorA;
import designPatterns.DecoratorB;
import designPatterns.DecoratorBase;
import org.junit.jupiter.api.Test;

class DecoratorATest {

    @Test
    public void test() {
        final DecoratorBase decoratorBase = new DecoratorBase();
        decoratorBase.print();


        final DecoratorA a_b_base_decorator = new DecoratorA(new DecoratorB(decoratorBase));
        a_b_base_decorator.print();
    }

}