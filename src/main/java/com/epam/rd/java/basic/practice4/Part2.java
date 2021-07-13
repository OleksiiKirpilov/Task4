package com.epam.rd.java.basic.practice4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;

public class Part2 {

    public static void main(String[] args) {
        String data = generateData();
        writeStringToFile("part2.txt", data);
        System.out.printf("input ==> %s", data);
        int[] numbers = loadData();
        sort(numbers);
        data = numbersToString(numbers);
        writeStringToFile("part2_sorted.txt", data);
        System.out.printf(" output ==> %s", data);
    }

    private static String numbersToString(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int n : numbers) {
            sb.append(n).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String generateData() {
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(rnd.nextInt(50)).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static int[] loadData() {
        String input = Part1.getInput("part2.txt");
        String[] strings = input.split(" ");
        int[] numbers = new int[strings.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        return numbers;
    }

    private static int[] sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[i]) {
                    swapElenemts(numbers, i, j);
                }
            }
        }
        return numbers;
    }

    private static void swapElenemts(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    public static void writeStringToFile(String filename, String output) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filename))) {
            w.write(output);
        } catch (IOException e) {
            Part1.getLogger().log(Level.SEVERE, e.getMessage());
        }
    }

}
