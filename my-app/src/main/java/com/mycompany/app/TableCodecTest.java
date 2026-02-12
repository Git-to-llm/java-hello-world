@@ -24,8 +24,8 @@ public class TableCodecTest {
         // TODO: enable when support Timestamp
         // .addColumn("c3", DateTimeType.DATETIME)
         // .addColumn("c4", TimestampType.TIMESTAMP)
         .addColumn("c5", StringType.VARCHAR)
         .addColumn("c6", StringType.VARCHAR)
         // .appendIndex("testIndex", ImmutableList.of("c1", "c2"), false)
         .build();
   }