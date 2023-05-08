package org.se.lab;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class StreamPipelineTest
{
    private List<String> list;

    @Before
    public void setUp()
    {
        list = Arrays.asList("eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun", "eins", "zwei", "drei");
    }


    // Source -> Intermediate Operations -> Terminal Operation
    // Intermediate operations return a new modified stream.
    // Intermediate operations can be chained.
    // The real thing of interest the result of the terminal operation.
    // Only one terminal operation can be used per stream.


    @Test
    public void testFiltering()
    {
        // @FunctionalInterface
        // public interface Predicate<T>
        // {
        //     boolean test(T t);
        // }

        list.stream()
                .filter(s -> s.length() <= 4)   // returns a stream including all elements
                                                // that match the given predicate
                .distinct()                     // returns a stream with unique elements
                .skip(2)                        // returns a stream with the first 2 elements discarded
                .limit(4)                       // returns a stream that is no longer then 4
                .forEach(System.out::println);
    }

    @Test
    public void testSorted()
    {
        list.stream()
                .sorted()   // Returns a stream consisting of the elements of this
                            // stream, sorted according to natural order.
                .forEach(System.out::println);


        // @FunctionalInterface
        // public interface Comparator<T>
        // {
        //    int compare(T o1, T o2);
        // }

        list.stream()
                .sorted(Comparator.reverseOrder())   // Stream<T> sorted(Comparator<? super T> comparator);
                .forEach(System.out::println);


        list.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }


    @Test
    public void testMatching()
    {
        // determining whether some elements match a given property.

        // @FunctionalInterface
        // public interface Predicate<T>
        // {
        //     boolean test(T t);
        // }

        // anyMatch() Returns whether any elements of this stream match
        // the provided predicate.
        assertTrue(list.stream().anyMatch(s -> s.charAt(0)=='n'));

        // noneMatch() Returns whether no elements of this stream match
        // the provided predicate.
        assertTrue(list.stream().noneMatch(s -> s.charAt(0)=='x'));

        // allMatch() Returns whether all elements of this stream match
        // the provided predicate.
        assertFalse(list.stream().allMatch(s -> s.length() < 4));
    }


    @Test
    public void testFind()
    {
        //  Use the operations findFirst and findAny for retrieving
        // arbitrary elements from a stream.

        list.stream()
                .findFirst()    // Returns an Optional describing the first
                                // element of this stream, or an empty Optional
                                // if the stream is empty.
                .ifPresent(System.out::println);

        list.stream()
                .findAny()      // Returns an Optional describing some element
                                // of the stream, or an empty Optional if the
                                // stream is empty.
                .ifPresent(System.out::println);


    }

    @Test
    public void testMapping()
    {
        // The method map takes a function as an argument to project
        // the elements of a stream into another form.

        // @FunctionalInterface
        // public interface Function<T, R>
        // {
        //     R apply(T t);
        // }

        list.stream()
                .map(String::length)   // The function is applied to each element
                                        // “mapping” it into a new element.
                .forEach(System.out::println);
    }


    @Test
    public void testReduce()
    {
        // @FunctionalInterface
        // public interface BinaryOperator<T> extends BiFunction<T,T,T>
        // {
        // }
        //
        // @FunctionalInterface
        // public interface BiFunction<T, U, R>
        // {
        //    R apply(T t, U u);
        // }

        Optional<Integer> sum = list.stream()
                .map(String::length)
                .reduce((a, b) -> a+b); // Performs a reduction on the elements
                                        // of this stream, using an accumulation
                                        // function, and returns an Optional
                                        // describing the reduced value, if any.

        sum.ifPresent(System.out::println);

        list.stream()
                .map(String::length)
                .reduce(Integer::max)
                .ifPresent(System.out::println);
    }
}
