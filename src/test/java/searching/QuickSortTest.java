package searching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class QuickSortTest {

    @ParameterizedTest
    @MethodSource("getSortImplementations")
    public void testSort_whenMixed_ReturnsSorted(QuickSort quickSort) {
        int[] input = new int[]{10, 2, 99, 6, 3, 54};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{2, 3, 6, 10, 54, 99}), Arrays.toString(input));
    }

    @ParameterizedTest
    @MethodSource("getSortImplementations")
    public void testSort_whenContainsEqualElements_ReturnsSorted(QuickSort quickSort) {
        int[] input = new int[]{10, 2, 99, 6, 3, 99, 54};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{2, 3, 6, 10, 54, 99, 99}), Arrays.toString(input));
    }

    @ParameterizedTest
    @MethodSource("getSortImplementations")
    public void testSort_whenContainsContiguousEqualElements_ReturnsSorted(QuickSort quickSort) {
        int[] input = new int[]{10, 2, 99, 99, 6, 3, 54};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{2, 3, 6, 10, 54, 99, 99}), Arrays.toString(input));
    }

    @ParameterizedTest
    @MethodSource("getSortImplementations")
    public void testSort_whenEmpty_ReturnsEmpty(QuickSort quickSort) {
        int[] input = new int[]{};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{}), Arrays.toString(input));
    }

    @ParameterizedTest
    @MethodSource("getSortImplementations")
    public void testSort_whenAscending_ReturnsAscending(QuickSort quickSort) {
        int[] input = new int[]{1, 10, 20, 90, 100};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{1, 10, 20, 90, 100}), Arrays.toString(input));
    }

    @ParameterizedTest
    @MethodSource("getSortImplementations")
    public void testSort_whenDescending_ReturnsAscending(QuickSort quickSort) {
        int[] input = new int[]{100, 90, 20, 5, 3};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{3, 5, 20, 90, 100}), Arrays.toString(input));
    }

    @ParameterizedTest
    @MethodSource("getSortImplementations")
    public void testSort_whenInputNegative_ReturnsSort(QuickSort quickSort) {
        int[] input = new int[]{10, 2, 99, 6, 3, 54, -1};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{-1, 2, 3, 6, 10, 54, 99}), Arrays.toString(input));
    }

    private static Stream<Arguments> getSortImplementations() {
        QuickSort quickSort = new QuickSortImpl();
        QuickSort quickSort2 = new QuickSortImplv2();

        return Stream.of(
                arguments(quickSort),
                arguments(quickSort2)
        );
    }
}