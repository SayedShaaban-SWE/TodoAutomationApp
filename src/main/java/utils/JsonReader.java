package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static Object[][] getJsonData(String jsonFilePath, String jsonFileData, int attributes) throws IOException, ParseException {

        Object object=new JSONParser().parse(new FileReader(jsonFilePath));

        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(jsonFileData);

        Object[][] arr =new String[jsonArray.size()][attributes];
        for (int i=0;i<jsonArray.size(); i++){
            JSONObject obj1 = (JSONObject) jsonArray.get(i);
            arr[i][0] = String.valueOf(obj1.get("TaskName"));
            arr[i][1] = String.valueOf(obj1.get("TaskDesc"));
        }
        return arr;
    }
}
