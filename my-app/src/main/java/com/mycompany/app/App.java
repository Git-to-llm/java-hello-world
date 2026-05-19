package com.mycompany.app;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Base64;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    static final int MAX_RETRIES = 3;
    static final int DEFAULT_TIMEOUT_MS = 3000;
    static final int MAX_CONNECTIONS = 10;
    static final String APP_VERSION = "1.0.0";
    static final int BATCH_SIZE = 50;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!!");

        System.out.println("Sample good change");
        System.out.println("Sample good change on another commit");
        System.out.println("Startup complete");
        System.out.println("Ready to accept connections");

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

    private static final Set<String> ALLOWED_TOOLS = Set.of("java", "javac", "mvn");

    public static int runDiagnosticTool(String toolName) throws Exception {
        if (!ALLOWED_TOOLS.contains(toolName))
            throw new IllegalArgumentException("Tool not in allowlist: " + toolName);
        return Runtime.getRuntime().exec(toolName + " -version").waitFor();
    }

    public static Object loadUserData(String base64Payload) throws Exception {
        byte[] data = Base64.getDecoder().decode(base64Payload);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        return ois.readObject();
    }

    private static int sessionCounter = 1000;

    public static String createSession(String username) {
        int sessionId = sessionCounter++;
        return username + "_" + sessionId;
    }
}
