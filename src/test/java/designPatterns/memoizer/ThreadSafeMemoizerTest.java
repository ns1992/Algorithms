package designPatterns.memoizer;

import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeMemoizerTest {

    @Test
    public void whenImpure_returnsPure() {
        final String input = "foo";
        final Function<String, UUID> impureFunc = string -> UUID.randomUUID();

        // Verify impure function
        assertNotSame(impureFunc.apply(input), impureFunc.apply(input));

        // Make impure function pure
        final Function<String, UUID> pureFunc = ThreadSafeMemoizer.memoize(impureFunc);
        assertSame(pureFunc.apply(input), pureFunc.apply(input));
    }

}