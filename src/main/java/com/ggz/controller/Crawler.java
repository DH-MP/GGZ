package com.ggz.controller;

import com.ggz.model.activejdbc.ActiveJDBCGame;
import com.ggz.model.activejdbc.GameDeserializer;
import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class Crawler
{
  private static final String API_KEY = "c6228329f1f67da8421899c69ba7694d20991eca";
  private static final String API_URL = "http://giantbomb.com/api/search";
  private static final String API_FORMAT = "json";
  private static final String API_RESOURCE_TYPE = "game";
  private static final String API_SORT = "original_release_date:desc";
  private static final String[] API_FIELD = {"api_detail_url", "deck",
      "description", "developers", "id", "image", "name",
      "original_release_date", "original_game_rating", "platforms"};

  public static void main(String[] args)
  {
    Crawler.search("mario");
  }

  public static List<ActiveJDBCGame> search(String q)
  {
    String queryURL = String.format("%s?api_key=%s&format=%s&query=%s&resources=%s&field_list=%s&sort=%s",
        API_URL, API_KEY, API_FORMAT, q, API_RESOURCE_TYPE, StringUtils.join(API_FIELD, ","), API_SORT);

    BufferedReader reader = null;
    StringBuffer apiPayload = new StringBuffer();
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(ActiveJDBCGame.class, new GameDeserializer());
    Gson gson = builder.create();
    List<ActiveJDBCGame> gameLibrary = null;

    try
    {
      URL url = new URL(queryURL);
//      reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
      reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("response.sample.txt")));

      JsonParser parser = new JsonParser();
      JsonObject results = parser.parse(reader).getAsJsonObject();
      if (!results.get("error").getAsString().equalsIgnoreCase("OK"))
        throw new Throwable("Something is wrong with the response payload.");

      gameLibrary = new ArrayList<ActiveJDBCGame>(results.get("number_of_total_results").getAsInt());

      JsonArray games = results.getAsJsonArray("results");
      if (games.size() < 1) throw new Throwable("Could not find any result with the associated search.");
      Iterator<JsonElement> it = games.iterator();

      for (;it.hasNext();)
      {
        JsonElement el = it.next();
        ActiveJDBCGame game = null;
        try
        {
          game = gson.fromJson(el, ActiveJDBCGame.class);
        }
        catch (ClassCastException e)
        {
          // Do nothing, just throw away the object
          game = null;
        }

        if (game != null)
          gameLibrary.add(game);
      }
    }
    catch (Throwable t)
    {
      System.out.println("Something went wrong in " + Crawler.class.toString() + ": " + t);
      t.printStackTrace();
    }

    return gameLibrary;
  }
}
