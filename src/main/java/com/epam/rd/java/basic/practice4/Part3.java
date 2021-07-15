package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    private static void show(String data, String regex) {
        Matcher m = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS).matcher(data);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            sb.append(m.group()).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        String data = Part1.getInput("part3.txt");
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            switch (in.nextLine()) {
                case "stop":
                    return;
                case "char":
                    show(data, "\\b(\\p{Alpha})\\b");
                    break;
                case "int":
                    show(data, "(?<![.\\d])([+-]?\\d+)(?![.\\d])");
                    break;
                case "String":
                    show(data, "\\b(\\p{Alpha}{2,})\\b");
                    break;
                case "double":
                    show(data, "([+-]?\\d*\\.\\d+)\\b");
                    break;
                default:
                    System.out.println("Incorrect input");
            }
        }
    }

}
