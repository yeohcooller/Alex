package com.alex.test;

public class RubbishRelease {
    static int j = 1;

    public RubbishRelease() {
        System.out.println(j++);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new RubbishRelease();
            new RubbishRelease();
            new RubbishRelease();
            System.gc();
        }
        System.out.println("over!");
    }

    public void finalize() {
        System.out.println("finalize...");
    }
}
