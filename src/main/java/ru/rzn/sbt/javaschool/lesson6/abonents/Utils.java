package ru.rzn.sbt.javaschool.lesson6.abonents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;

public class Utils {
    public static <T, R> Collection<R> transform(Collection<T> src, Function<T, R> function) {
        Collection<R> result = new ArrayList<>();
        for(T item: src) {
            result.add(function.apply(item));
        }
        return result;
    }

    public static <T> Collection<T> filter(Collection<T> src, Predicate<T> predicate) {
        Collection<T> result = new ArrayList<>();
        for(T item : src) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> int count(Collection<T> src, Predicate<T> predicate) {
        int result = 0;
        for(T item : src)
            if (predicate.test(item)) result++;
        return result;
    }

    public static <T> boolean contains(Collection<T> src, Predicate<T> predicate) {
        for(T item : src) {
            if (predicate.test(item))
                return true;
        }
        return false;
    }
}
