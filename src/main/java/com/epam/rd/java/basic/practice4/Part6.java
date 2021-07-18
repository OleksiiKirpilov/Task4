package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        String data = Part1.getInput("part6.txt");
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            switch (line.toLowerCase()) {
                case "stop":
                    return;
                case "cyrl":
                    show(data, "\\p{IsCyrillic}+", line);
                    break;
                case "latn":
                    show(data, "[A-Za-z]+", line);
                    break;
                default:
                    System.out.println(line + ": Incorrect input");
            }
        }
    }

    private static void show(String data, String regex, String line) {
        Matcher m = Pattern.compile(regex).matcher(data);
        StringBuilder sb = new StringBuilder();
        System.out.print(line + ": ");
        while (m.find()) {
            sb.append(m.group()).append(' ');
        }
        System.out.println(sb);
    }

}
