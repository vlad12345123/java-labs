import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class JsonUtils {

    public static String parseUrl(URL url) {
        if (url == null)
            return "";

        StringBuilder stringBuilder = new StringBuilder();
      
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void parseCurrentWeatherJson(String resultJson) throws ParseException {
        JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
        System.out.println("Название города: " + weatherJsonObject.get("name"));
        System.out.println("Код страны: " + weatherJsonObject.get("cod"));
        JSONArray weatherArray = (JSONArray) weatherJsonObject.get("weather");
        JSONObject weatherData = (JSONObject) weatherArray.get(0);
        System.out.println("Погода на данный момент: " + weatherData.get("main"));
        System.out.println("Более детальное описание погоды: " + weatherData.get("description"));
    }

    public static void parseCurrentWindJson(String resultJson) throws ParseException {
        JSONObject windJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
        JSONObject windObject = (JSONObject) windJsonObject.get("wind");
        System.out.println("Скорость направления ветра : " + windObject.get("speed") + " м/c");
    }

    public static void parseCurrentMainJson(String resultJson) throws ParseException {
        JSONObject mainJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
        JSONObject mainObject = (JSONObject) mainJsonObject.get("main");
        System.out.println("Текушая температура : " + mainObject.get("temp") + "K");
        System.out.println("Влажность : " + mainObject.get("humidity") + " %");
        System.out.println("Давление: " + mainObject.get("pressure") + " мм рт. ст.");
        System.out.println("Минимальная температура за сегодня : " + mainObject.get("temp_min") + " K");
        System.out.println("Максимальная температура за сегодня : " + mainObject.get("temp_max") + " K");
    }

    public static void parseCurrentCloudsJson(String resultJson) throws ParseException {
        JSONObject cloudsJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
        JSONObject cloudsObject = (JSONObject) cloudsJsonObject.get("clouds");
        System.out.println("Облачность: " + cloudsObject.get("all") + "%");
    }
}