package com.bank;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static int getInputAsInt() {
        return Integer.parseInt(sc.nextLine());
    }

    public static String getInputAsString() {
        return sc.nextLine();
    }

    private UserInput() {
    }

    ;
}
