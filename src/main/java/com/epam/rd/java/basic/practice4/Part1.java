package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final Logger LOGGER = Logger.getGlobal();

    public static Logger getLogger() {
        return LOGGER;
    }

    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            getLogger().log(Level.SEVERE, ex.getMessage(), ex);
        }
        return sb.toString();
    }

    public static String process(String input) {
        Matcher m = Pattern.compile("[\\w]{4,}", Pattern.UNICODE_CHARACTER_CLASS).matcher(input);
        StringBuilder sb = new StringBuilder(input);
        int deletedCount = 0;
        while (m.find()) {
            int index = m.start() - deletedCount;
            sb.delete(index, index + 2);
            deletedCount += 2;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String input = getInput("part1.txt");
        System.out.println(process(input));
    }

}
