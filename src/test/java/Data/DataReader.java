package Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataReader {

        public String name;

        public void reader() throws FileNotFoundException, IOException, ParseException {
            String path =System.getProperty("user.dir")+"//src//test//java//Data//data.json";
            File srcfile = new File(path);
            JSONParser parser = new JSONParser();
            JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcfile));

            for(Object yobject : jarray) {
                JSONObject person = (JSONObject) yobject;
                name=(String) person.get("name");
            }
        }
    }

