import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParseTest {

    private static final String filePath = "exampleFile.json";

    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader(filePath); //json reader

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            String firstName = (String) jsonObject.get("firstname"); //get string from obj
            System.out.println("The first name is: " + firstName);

            // get num from obj
            long id =  (long) jsonObject.get("id");
            System.out.println("The id is: " + id);

            // get arr
            JSONArray lang= (JSONArray) jsonObject.get("languages");

            // get elem of arr
            for(int i=0; i<lang.size(); i++){
                System.out.println("The " + i + " element of the array: "+lang.get(i));
            }
            Iterator i = lang.iterator();

            // get values from arr
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                System.out.println("language "+ innerObj.get("lang") +
                        " with level " + innerObj.get("knowledge"));
            }
            // work with all structs
            JSONObject structure = (JSONObject) jsonObject.get("job");
            System.out.println("Into job structure, name: " + structure.get("name"));

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

}