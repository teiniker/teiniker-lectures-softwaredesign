package org.se.lab;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreamsTest
{

    @Test
    public void testEmptyStream()
    {
        // Empty streams are used to avoid returning null pointers.
        Stream<String> stream = Stream.empty();
    }

    @Test
    public void testStreamOfCollection()
    {
        List<String> list = Arrays.asList("eins", "zwei", "drei", "vier", "fünf");

        // Streams can be created from Collection, List, Set, etc.
        Stream<String> stream = list.stream();
    }


    @Test
    public void testStreamOfArray()
    {
        String[] array = new String[] {"eins", "zwei", "drei", "vier", "fünf"};

        // Streams can be created from an existing array
        Stream<String> stream = Arrays.stream(array);
    }


    @Test
    public void testStreamOfVarArg()
    {
        // public static<T> Stream<T> of(T... values)
        Stream<String> stream = Stream.of("eins", "zwei", "drei", "vier", "fünf");
    }

    @Test
    public void testStreamBuilder()
    {
        // The desired type should be specified, otherwise a Stream<Object> will be created!
        Stream.<String>builder()
                .add("eins")
                .add("zwei")
                .add("drei")
                .add("vier")
                .add("fünf");
    }
}
