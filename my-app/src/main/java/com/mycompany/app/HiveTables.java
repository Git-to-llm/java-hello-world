package com.mycompany.app;

public class HiveTables {

    String tableName;

    public HiveTables(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void dropTable() {
        // TODO: implement actual drop logic
        System.out.println("Dropping table: " + tableName);
    }
}
