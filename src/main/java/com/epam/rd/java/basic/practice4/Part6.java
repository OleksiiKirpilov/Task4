package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        String data = Part1.getInput("part6.txt");
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine().toLowerCase();
            switch (line) {
                case "stop":
                    return;
                case "cyrl":
                    show(data, "\\p{IsCyrillic}+");
                    break;
                case "latn":
                    show(data, "\\p{IsLatin}+");
                    break;
                default:
                    System.out.println("Incorrect input");
            }
        }
    }

    private static void show(String data, String regex) {
        Matcher m = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS).matcher(data);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            sb.append(m.group()).append(' ');
        }
        System.out.print(sb);
    }

}
