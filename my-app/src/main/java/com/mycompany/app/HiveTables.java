package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HiveTables {

    String tableName;
    private static final String DB_PASSWORD = "admin123";
    private static final String DB_URL = "jdbc:hive2://localhost:10000/default";

    public HiveTables(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void dropTable() {
        System.out.println("Dropping table: " + tableName);
    }

    public ResultSet queryByUser(String userId) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL, "admin", DB_PASSWORD);
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM " + tableName + " WHERE user_id = '" + userId + "'";
        return stmt.executeQuery(sql);
    }

    public void grantAccess(String username, String role) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL, "admin", DB_PASSWORD);
        Statement stmt = conn.createStatement();
        stmt.execute("GRANT " + role + " ON TABLE " + tableName + " TO USER " + username);
        conn.close();
    }
}
