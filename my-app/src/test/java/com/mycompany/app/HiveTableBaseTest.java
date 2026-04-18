package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;

public class HiveTableBaseTest {

    protected static final String DB_NAME = "test_db";
    protected static final String TABLE_NAME = "test_table";

    protected HiveTables tables;

    @BeforeEach
    public void setUp() {
        tables = new HiveTables(TABLE_NAME);
    }
}
