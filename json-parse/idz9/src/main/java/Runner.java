import org.json.simple.parser.ParseException;
import java.net.URL;

public class Runner {
    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=Paris,fr&appid=07a16003c4da166d8d501a52fd9a11f6";

    public static void main(String[] args) throws ParseException {
        URL url = JsonUtils.createUrl(WEATHER_URL);
        String resultJson = JsonUtils.parseUrl(url);
        JsonUtils.parseCurrentWeatherJson(resultJson);
        JsonUtils.parseCurrentWindJson(resultJson);
        JsonUtils.parseCurrentMainJson(resultJson);
        JsonUtils.parseCurrentCloudsJson(resultJson);
    }
}