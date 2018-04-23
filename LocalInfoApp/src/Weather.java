import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Weather {

	public static String getLocalTemp(String zip) throws MalformedURLException, IOException {
	    
		// Open http connection to weather.com based on zipcode.
		URL url = new URL("https://weather.com/weather/today/l/" + zip + ":4:US");
	    HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
	    httpCon.setRequestMethod("GET");
	    
	    // Read website text in UTF-8.
		BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuilder a = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			a.append(inputLine);
		in.close();
		
		// Split buffered text so we can parse the current local temperature.
		String [] tempStr = a.toString().split(",");
		String tmp = "";
		// Find the local temparature from the tempStr array. It'll be right after the first instance of "tmp"
		for (int i = 0; i < tempStr.length; i++){
			if (tempStr[i].contains("\"tmp\"")){
				tmp = tempStr[i+1]; // +1 because the temperature is in the next index in the tempStr
			}
		}
		
		httpCon.disconnect();
		
		return tmp;
	}
}
