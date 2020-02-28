import sad.json.write.JSONWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {

    static JSONObject x = null;

    static String[] arrColumn = new String[] {"Name","Password","Age"};
    static String[] arrRow;

    public static void main(String [] args) throws Exception {

        JSONWriter write = new JSONWriter();
        JSONObject[] x = new JSONObject[2];
        JSONArray v = new JSONArray();

        arrRow = new String[]{"asd", "bsd", "asdzx"};
        x[0] = write.JSONObjectSet(arrColumn, arrRow);

        arrRow = new String[]{"asd1", "bsd1", "asdzx1"};
        x[1] = write.JSONObjectSet(arrColumn, arrRow);

        for (int i = 0; i < x.length; i++) {
            JSONObject a = write.JSONTable("Employee", x[i]);
            v.add(a);
        }
        write.writeJSON("test.json", v);
    }
}