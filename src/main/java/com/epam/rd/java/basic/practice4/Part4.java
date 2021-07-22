package com.epam.rd.java.basic.practice4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part4 implements Iterable<String> {

    private final String text;

    public Part4(String s) {
        text = s;
    }

    public static void main(String[] args) {
        String input = Part1.getInput("part4.txt").replace(System.lineSeparator(), " ");
        Part4 t = new Part4(input);
        for (String s : t) {
            System.out.println(s);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new SentenceIterator();
    }

    private class SentenceIterator implements Iterator<String> {

        private final Pattern pattern = Pattern.compile("\\p{javaUpperCase}+[^.]+\\.*");
        private final Matcher matcher = pattern.matcher(Part4.this.text);

        @Override
        public boolean hasNext() {
            return matcher.find();
        }

        @Override
        public String next() {
            try {
                return matcher.group();
            } catch (IllegalStateException e) {
                throw new NoSuchElementException();
            }
        }
    }

}
