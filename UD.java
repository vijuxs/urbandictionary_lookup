
/***

  Displays definitions from Urban dictionary in raw JSON
  @@author viju
  @@licence http://www.wtfpl.net
  Date: 11 April 2021

**/

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URLEncoder;

public class UD {

  public static void main(String...args) {

    if (args != null && args.length == 0) {
      System.out.println("You didn't provide any phrase/words to search");
      System.out.println("Usage:> java UD <your phrase>");
      return;
    }

    String phrase = convertToString(args);
    try {
        phrase = URLEncoder.encode(phrase, "UTF-8");
        String urlString = "https://api.urbandictionary.com/v0/define?term=" + phrase;

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection.getResponseCode() != 200) {
          System.out.println("Something went wrong. HTTP code: " + connection.getResponseCode());
          return;
        }

        String message = connection.getResponseMessage();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String read = null;
        while ((read = reader.readLine()) != null) {
          System.out.println(read);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public static String convertToString(String[] args) {
    //TODO: any better way to write this?
    String words = "";
    for (String a : args) {
     words = words + " " + a;
    }
    return words.trim();
  }
}
