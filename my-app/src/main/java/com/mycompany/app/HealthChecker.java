package com.mycompany.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HealthChecker {
    public static void main(String[] args) throws Exception {
        System.out.println("Running health check...");

        if (args.length > 0 && args[0].equals("--check")) {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("java -version");
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            String s;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}
