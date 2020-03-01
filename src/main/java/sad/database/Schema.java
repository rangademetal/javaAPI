package sad.database;

import java.io.IOException;
import java.sql.*;

public class Schema implements Database {
    private String URL;
    private String user;
    private String pass;

    public Schema(String URL, String user, String pass) {
        this.URL = URL;
        this.user = user;
        this.pass = pass;
    }

    public void getSchema() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, user, pass);
            DatabaseMetaData metadata = con.getMetaData();
            ResultSet result = metadata.getCatalogs();
            while (result.next()) {
                System.out.println("Schema: " + result.getString(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

    public int setSchema(String schema) {
        int work = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, user, pass);
            Statement stmt = con.createStatement();

            work = stmt.executeUpdate("CREATE SCHEMA " + schema);
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return work;
    }

    public int removeSchema(String schema) {
        int work = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, user, pass);
            Statement stmt = con.createStatement();

            work = stmt.executeUpdate("DROP SCHEMA " + schema);
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return work;
    }

    public void getTable(String schema) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL + schema, user, pass);
            DatabaseMetaData metadata = con.getMetaData();

            ResultSet result = metadata.getTables(null, null, null, new String[]{"TABLE"});
            while (result.next()) {
                System.out.println("Table from " + schema + ":" + result.getString("TABLE_NAME"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

    public int removeTable(String schema,String table) {
        int work =0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL + schema, user, pass);
            Statement stmt = con.createStatement();
            work = stmt.executeUpdate("DROP TABLE "+table);
            con.close();
        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
        return work;

    }
}