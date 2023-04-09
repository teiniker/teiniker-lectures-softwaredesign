package org.se.lab;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ForEachTest
{

    @Test
    public void testForEachList()
    {
        // setup
        List<String> list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");

        list.forEach(s -> System.out.println(s));
        //list.stream().forEach(System.out::println);
    }

    @Test
    public void testForEachMap()
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1234567");
        map.put(2, "qwerty");

        map.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });
    }

    @Test
    public void testForEachMutableObject()
    {
        List<Password> passwords = Arrays.asList(new Password("1234567"), new Password("qwerty"));

        passwords.forEach(p -> p.setPassword(DigestUtil.toHashString(p.getPassword())));

        System.out.println(passwords);
    }
}
