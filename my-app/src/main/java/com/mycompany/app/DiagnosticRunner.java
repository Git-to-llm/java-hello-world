package com.mycompany.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiagnosticRunner {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("java -version");
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String s;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}
