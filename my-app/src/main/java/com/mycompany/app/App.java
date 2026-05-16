package com.mycompany.app;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Base64;

/**
 * Hello world!
 */
public class App {
    static final int MAX_RETRIES = 3;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!!");

        System.out.println("Sample good change");
        System.out.println("Sample good change on another commit");
        System.out.println("Startup complete");

        if (args.length > 0) {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(args[0]);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String s;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
        }
    }

    public static Object loadUserData(String base64Payload) throws Exception {
        byte[] data = Base64.getDecoder().decode(base64Payload);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        return ois.readObject();
    }
}
