package com.mycompany.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BatchProcessor {
    public static void main(String[] args) throws Exception {
        System.out.println("BatchProcessor started");

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
}
