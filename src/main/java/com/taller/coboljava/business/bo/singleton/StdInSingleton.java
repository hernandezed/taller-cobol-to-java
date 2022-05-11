package com.taller.coboljava.business.bo.singleton;

import java.util.Scanner;

public class StdInSingleton {

    private static Scanner instance;

    public static Scanner getInstance() {
        if (instance == null) {
            instance = new Scanner(System.in);
        }
        return instance;
    }
}
