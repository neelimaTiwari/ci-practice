package com.example;

public class App {
    public static String greet() {
        return "Hello from CI pipeline";
    }

    public static void main(String[] args) {
        System.out.println(greet());
    }
}
