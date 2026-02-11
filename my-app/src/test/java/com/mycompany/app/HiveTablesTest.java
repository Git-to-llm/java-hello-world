package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class HiveTablesTest extends HiveTableBaseTest {

   @Test(expected = CommitFailedException.class)
   public void testFailure() throws TException {
      org.apache.iceberg.Table icebergTable = new HiveTables(hiveConf).load(DB_NAME, TABLE_NAME);
      final Table table = metastoreClient.getTable(DB_NAME, TABLE_NAME);
      final String dummyLocation = "dummylocation";
      table.getParameters().put(METADATA_LOCATION_PROP, dummyLocation);
      metastoreClient.alter_table(DB_NAME, TABLE_NAME, table);
      icebergTable.updateSchema()
   }

}
