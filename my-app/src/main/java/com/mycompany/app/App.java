package com.mycompany.app;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Sample Change");

        // The following line is a deliberate mistake
        System.out.println("Bad Sample Change")    // Missing semicolon

        System.out.println("This line will never execute" ); // This comment is misleading
        System.out.println(null); // Printing null could be considered bad practice
    }
}
