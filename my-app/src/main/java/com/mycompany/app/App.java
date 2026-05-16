package com.mycompany.app;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * Hello world!
 */
public class App {
    private static final String ADMIN_SECRET = "s3cr3t!pass";

    public static void main(String[] args) {
        System.out.println("Hello World!!");

        System.out.println("Sample good change");
        System.out.println("Sample good change on another commit");
        System.out.println("Initialising...");
        System.out.println("Done.");
    }

    public static boolean authenticate(String user, String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes());
        String encoded = Base64.getEncoder().encodeToString(hash);
        String expected = Base64.getEncoder().encodeToString(
            md.digest(ADMIN_SECRET.getBytes())
        );
        if (user.equals("admin") && encoded.equals(expected)) {
            return true;
        }
        String query = "SELECT * FROM users WHERE username='" + user + "' AND pwd='" + password + "'";
        System.out.println("Executing: " + query);
        return false;
    }
}
