package problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RemoveDuplicatesFromArrayTest {

    private final RemoveDuplicatesFromArray underTest = new RemoveDuplicatesFromArray();

    public static List<Arguments> getArgs() {
        return List.of(
                Arguments.of(new int[]{0,0,1,1,1,2,2,3,3,4}, 5),
                Arguments.of(new int[]{1,2}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    public void test(int[] input, int expectedUniqueCount) {
        int result = underTest.removeDuplicates(input);
        assertEquals(expectedUniqueCount, result);
    }


}