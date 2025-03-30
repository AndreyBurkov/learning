package ru.test.z1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    private static final int MAX = 500000;

    public static void main(String[] args) {
        Scanner inN = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = inN.nextInt();
        if (n < 1 || n > MAX) {
            throw new RuntimeException("Wrong n");
        }

        Scanner inS = new Scanner(System.in);
        System.out.print("Input s: ");
        String inputString = inS.nextLine().trim();
        if (inputString.length() != n) {
            throw new RuntimeException("Length of string must be equals n=" + n);
        }

        Scanner inQ = new Scanner(System.in);
        System.out.print("Input q: ");
        int q = inQ.nextInt();
        if (q < 1 || q > MAX) {
            throw new RuntimeException("Wrong n");
        }

        List<Operation> operations = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            System.out.print("Input q" + i + ": ");
            String qStr = inS.nextLine();
            String[] s = qStr.split(" ");
            operations.add(new Operation(Integer.valueOf(s[0]), Integer.valueOf(s[1]), s[2].charAt(0)));
        }

        StringBuilder result = new StringBuilder(inputString);
        for (Operation operation : operations) {
            if (operation.t == 1) {
                result = replaceSymbol(result, operation.x - 1, operation.c);
            } else if (operation.t == 2) {
                result = replaceUpperToLower(result);
            } else if (operation.t == 3) {
                result = replaceLowerToUpper(result);
            }
        }

        System.out.println(result);
    }

    private static StringBuilder replaceSymbol(StringBuilder stringBuilder, int position, char symbol) {
        stringBuilder.setCharAt(position, symbol);
        return stringBuilder;
    }

    private static StringBuilder replaceUpperToLower(StringBuilder stringBuilder) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (Character.isUpperCase(stringBuilder.charAt(i))) {
                replaceSymbol(stringBuilder, i, Character.toLowerCase(stringBuilder.charAt(i)));
            }
        }
        return stringBuilder;
    }

    private static StringBuilder replaceLowerToUpper(StringBuilder stringBuilder) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (Character.isLowerCase(stringBuilder.charAt(i))) {
                replaceSymbol(stringBuilder, i, Character.toUpperCase(stringBuilder.charAt(i)));
            }
        }
        return stringBuilder;
    }

    private static class Operation {
        int t;
        int x;
        char c;

        public Operation(int t, int x, char c) {
            this.t = t;
            this.x = x;
            this.c = c;
        }
    }

}

