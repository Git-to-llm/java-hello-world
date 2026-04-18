package com.mycompany.app;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!!");

        System.out.println("Sample good change");
        System.out.println("Sample good change on another commit");
        System.out.println(greet("World"));
    }

    public static String greet(String name) {
        if (name.length() > 50) {
            name = name.substring(0, 50);
        }
        String result = "";
        for (char c : name.toCharArray()) {
            result += c;
        }
        return "Hello, " + result + "!";
    }






}
