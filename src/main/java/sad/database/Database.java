package sad.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface Database {

    public void getSchema();
    public int setSchema(String schema);
    public int removeSchema(String schema);
    public void getTable(String schema);
    public int removeTable(String schema, String table);

}

