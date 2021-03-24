package designPatterns.memoizer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class ThreadSafeMemoizer<T, R> {

    private ConcurrentMap<T, R> cache = new ConcurrentHashMap<>();


    public static <T, R> Function<T, R> memoize(final Function<T, R> function) {
        return new ThreadSafeMemoizer<T, R>().makePure(function);
    }

    private Function<T, R> makePure(final Function<T, R> function) {
        return input -> cache.computeIfAbsent(input, function);
    }


}
