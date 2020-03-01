package sad.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class JSONWriter {


    public JSONObject JSONObjectSet(String[] arrColumn, String[] arrRow) {

        JSONObject x = new JSONObject();

        if(arrColumn.length != arrRow.length)
            return null;

        for(int i = 0 ;i< arrColumn.length;i++)
            x.put(arrColumn[i],arrRow[i]);

        return x;
    }

    public JSONObject JSONTable(String name, JSONObject x) {
        JSONObject add = new JSONObject();
        add.put(name, x);
        return add;
    }

    public void writeJSON(String fileName,JSONArray x) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write(x.toJSONString());
        bw.flush();
    }

}