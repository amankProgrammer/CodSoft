import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) throws IOException, InterruptedException {

        HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();

        currencyCodes.put(1, "INR");
        currencyCodes.put(2, "USD");
        currencyCodes.put(3, "EUR");
        currencyCodes.put(4, "AUD");
        currencyCodes.put(5, "CAD");
        currencyCodes.put(6, "JPY");
        currencyCodes.put(7, "HKD");

        String fromCode, toCode;
        double amount;

        Scanner sc = new Scanner(System.in);

        System.out.println("Currency converter application!");
        System.out.println("Which currency are you converting from?");
        System.out.println("1: INR (Indian rupees) \t 2: USD (U.S. dollar) \t 3: EUR (euro) \t 4: AUD (American dollar) \t 5: CAD (Canadian dollar) \t 6: JPY (Japanese yen) \t 7: HKD (Hongkong dollar) "); 
        fromCode = currencyCodes.get(sc.nextInt()); 

        System.out.println("Which currency are you converting to?");
        System.out.println("1: INR (Indian rupees) \t 2: USD (U.S. dollar) \t 3: EUR (euro) \t 4: AUD (American dollar) \t 5: CAD (Canadian dollar) \t 6: JPY (Japanese yen) \t 7: HKD (Hongkong dollar) "); 
        toCode = currencyCodes.get(sc.nextInt()); 

        System.out.print("Enter amount you like to convert : ");
        amount = sc.nextFloat();

        sendHttpGETRequest(fromCode, toCode, amount);
        sc.close();
        System.out.println("Conversion complete!");
    }

    private static void sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException, InterruptedException {
        
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://currency-exchange.p.rapidapi.com/exchange?from="+ fromCode + "&to=" + toCode + "&q=" + amount))
		.header("X-RapidAPI-Key", "3b2005c9admsh1d2ed918cc98dfdp15f031jsn18ef15c6302d")
		.header("X-RapidAPI-Host", "currency-exchange.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        System.out.println("Please Wait.....");
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        // System.out.println(response.body());

        String toFloat = response.body().substring(0,4);
        float value = Float.parseFloat(toFloat) * (float)amount;
        System.out.println(amount + " " + fromCode + " = " + value + " " + toCode);

    }
}
