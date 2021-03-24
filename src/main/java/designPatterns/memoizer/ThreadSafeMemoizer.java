package designPatterns.memoizer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class ThreadSafeMemoizer<T, R> {

    private final ConcurrentMap<T, R> cache = new ConcurrentHashMap<>();

    private ThreadSafeMemoizer() {

    }

    public static <T, R> Function<T, R> memoize(final Function<T, R> function) {
        return new ThreadSafeMemoizer<T, R>().doMemoize(function);
    }


    private Function<T, R> doMemoize(final Function<T, R> function) {
        return input -> cache.computeIfAbsent(input, function);
    }

}
