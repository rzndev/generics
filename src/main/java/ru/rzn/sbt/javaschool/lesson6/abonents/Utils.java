package ru.rzn.sbt.javaschool.lesson6.abonents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;

public class Utils {
    /** Метод преобразования коллекции
     * В методе к каждому элементу src применяется function.apply(),
     *  * формируется результат преобразования из объекта типа T в объект типа R
     * @param src исходная коллекция
     * @param function интерфейс преобразования
     * @param <T> тип данных в исходной коллекции
     * @param <R> тип данных в возвращаемой коллекции
     * @return
     */
    public static <T, R> Collection<R> transform(Collection<T> src, Function<T, R> function) {
        Collection<R> result = new ArrayList<>();
        for(T item: src) {
            result.add(function.apply(item));
        }
        return result;
    }

    /**
     * Метод к каждому элементу src применяет predicate.test(),
     * и, в зависимости от результата проверки, формирует отфильтрованный {@link Collection}
     * @param src исходная коллекция
     * @param predicate предикат
     * @param <T> тип данных в коллекции
     * @return коллекция, каждый элемент которой при передаче в predicate.test() обеспечивает возврат predicate.test()
     * значения true
     */
    public static <T> Collection<T> filter(Collection<T> src, Predicate<T> predicate) {
        Collection<T> result = new ArrayList<>();
        for(T item : src) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод подсчета количества элементов коллекции src, которые при передаче в predicate.test() обеспечивают возврат
     * predicate.test() значения true;
     * @param src исходная коллекция
     * @param predicate предикат
     * @param <T> тип данных в коллекции
     * @return количесвтво элементов коллекции, удовлетворяющих условию в predicate
     */
    public static <T> int count(Collection<T> src, Predicate<T> predicate) {
        int result = 0;
        for(T item : src)
            if (predicate.test(item)) result++;
        return result;
    }

    /**
     * Метод, определяющй наличие элемента в коллекции src, удовлтворяюий условию в методе predicate.test()
     * @param src исходная коллекция
     * @param predicate предикат
     * @param <T> тип данных в коллекции
     * @return true, если хотя бы один элемет коллекции src при передаче в predicate.test() обеспечивает возврат
     * predicate.test() значеня true
     */
    public static <T> boolean contains(Collection<T> src, Predicate<T> predicate) {
        for(T item : src) {
            if (predicate.test(item))
                return true;
        }
        return false;
    }
}
