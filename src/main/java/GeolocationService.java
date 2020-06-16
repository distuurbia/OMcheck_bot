import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Objects;

public class GeolocationService {
    private static final String GEOCODE_PATH = "http://maps.googleapis.com/maps/api/geocode/json";
    private static final String MAPS_API_KEY = "AIzaSyCM3415_U0q_2nUkQDQ71-nilE9QllL2yU";


    public Coordinates geocodeLocation(String address) {
        URL url;
        try {
            url = new URL(GEOCODE_PATH + "?apikey=" + MAPS_API_KEY + "&geocode=" + URLEncoder.encode(address, HTTP.UTF_8) + "&format=json&results=1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");


            if (con.getResponseCode() == 200) {
                String json = readData(con);
                return  null;//----------------------------------
               // return new JsonEntitiesMapper().mapCoords(json);
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private String readData(HttpURLConnection connection) {
        StringBuilder result = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Objects.requireNonNull(result).toString();
    }
}
