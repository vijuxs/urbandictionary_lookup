
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public class UD {

  public static void main(String...args) {

    if (args != null && args.length == 0) {
      System.out.println("You didn't provide any phrase/words to search");
      System.out.println("Usage:> java UD <your phrase>");
      return;
    }
    String rawJson = "";
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
         
          rawJson += read;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      EntryList entryList = readFromJson(rawJson);
      System.out.println(entryList.getEntries());
      List<Entry> entries = entryList.getEntries();
      for (Entry e : entries) {
       System.out.println(e.getDefId() + " : " + e.getDefinition());
       System.out.println("----------------------------------------");
      }
  }

  private static String convertToString(String[] args) {
    //TODO: any better way to write this?
    String words = "";
    for (String a : args) {
     words = words + " " + a;
    }
    return words.trim();
  }

  private static EntryList readFromJson(String rawJson) {
    
    if (rawJson == null || rawJson.equals("")) {
      return null;
    }

    EntryList entries = new EntryList();
    ObjectMapper mapper = new ObjectMapper();
    try {
      Entry entry = new Entry();
      entries = mapper.readValue(rawJson, new TypeReference<EntryList>(){});
      // entries = mapper.readValue(rawJson, EntryList.class);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return entries;
  }
}
