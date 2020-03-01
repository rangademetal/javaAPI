import sad.database.*;

import java.sql.SQLException;

public class Main {

    public static void main(String [] args) throws SQLException, ClassNotFoundException {
        Database db = new Schema("jdbc:mysql://localhost:3306/","root","Sad1996.");

        System.out.println("SHOW SCHEMAS");
        db.getSchema();

        System.out.println("SHOW TABLES;");
        db.getTable("tutorials");

        System.out.println("DROP TABLE");
        db.removeTable("tutorials","test");

        System.out.println("SHOW TABLES;");
        db.getTable("tutorials");


//        db.setSchema("Test");
//        db.getSchema();
//        db.removeSchema("Test");
//        db.getSchema();

    }
}