package searching;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    private final BinarySearch underTest = new BinarySearch();


    public static List<Arguments> getArgs() {
        return List.of(
                Arguments.of(new int[]{1}, 1, 0),
                Arguments.of(new int[]{1, 4, 6, 8, 20}, 4, 1),
                Arguments.of(new int[]{1, 4, 6, 8, 20}, 6, 2),
                Arguments.of(new int[]{1, 4, 6, 8, 20}, 8, 3),
                Arguments.of(new int[]{1, 4, 6, 8, 20}, 20, 4),
                Arguments.of(new int[]{1, 4, 6, 8, 20}, 1, 0),
                Arguments.of(new int[]{1, 4, 6, 8, 20}, 99, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    public void test(int[] input, int target, int index) {
        int result = underTest.search(input, target);
        assertEquals(index, result);
    }

}