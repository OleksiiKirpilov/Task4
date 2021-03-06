package com.epam.rd.java.basic.practice4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Demo {

    private static final InputStream STD_IN = System.in;

    private static ByteArrayInputStream prepareMockStream(String input) {
        return new ByteArrayInputStream(input
                .replace("^", System.lineSeparator())
                .getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) {
        System.out.println("=========================== PART1");
        Part1.main(args);

        System.out.println("=========================== PART2");
        Part2.main(args);

        System.out.println("=========================== PART3");
        System.setIn(prepareMockStream("char^String^int^double^stop"));
        Part3.main(args);
        System.setIn(STD_IN);

        System.out.println("=========================== PART4");
        Part4.main(args);

        System.out.println("=========================== PART5");
        System.setIn(prepareMockStream("table ru^table en^apple ru^stop"));
        Part5.main(args);
        System.setIn(STD_IN);

        System.out.println("=========================== PART6");
        System.setIn(prepareMockStream("Latn^Cyrl^asdf^latn^cyrl^stop"));
        Part6.main(args);
        System.setIn(STD_IN);
    }
}
