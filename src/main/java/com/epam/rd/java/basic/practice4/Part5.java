package com.epam.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine().toLowerCase();
            if (line.equals("stop")) {
                return;
            }
            show(line.split(" "));
        }
    }

    private static void show(String[] words) {
        Locale l = new Locale(words[1]);
        ResourceBundle keys = ResourceBundle.getBundle("resource", l);
        System.out.println(keys.getString(words[0]));
    }

}
