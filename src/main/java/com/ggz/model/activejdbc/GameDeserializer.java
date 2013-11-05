package com.ggz.model.activejdbc;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameDeserializer implements JsonDeserializer<ActiveJDBCGame>
{
  @Override
  public ActiveJDBCGame deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException
  {
    ActiveJDBCGame game = new ActiveJDBCGame();
    JsonObject ob = json.getAsJsonObject();
    game.setApiId(ob.get("id").getAsInt());
    game.setName(ob.get("name").getAsString());
    game.setApiDetailUrl(ob.get("api_detail_url").getAsString());
    game.setDeck(ob.get("deck").getAsString());
    game.setDescription(ob.get("description").getAsString());

    JsonObject imagesUrl = ob.getAsJsonObject("image");
    Map<String, String> imagesUrlMap = new HashMap<String, String>();
    imagesUrlMap.put("large", imagesUrl.get("super_url").getAsString());
    imagesUrlMap.put("medium", imagesUrl.get("thumb_url").getAsString());
    imagesUrlMap.put("small", imagesUrl.get("tiny_url").getAsString());

    game.setImagesUrl(imagesUrlMap);

    JsonElement jel = ob.get("original_release_date");
    if (jel != null) game.setReleaseDate(jel.getAsString());

    JsonArray gameRating = ob.getAsJsonArray("original_game_rating");
    if (gameRating != null)
    {
      List<String> gameRatingList = new ArrayList<String>(gameRating.size());
      for (JsonElement el : gameRating)
        gameRatingList.add(el.getAsJsonObject().get("name").getAsString());
      game.setPgRating(gameRatingList);
    }

    JsonArray gameDevelopers = ob.getAsJsonArray("developers");
    if (gameDevelopers != null)
    {
      List<String> gameDevelopersList = new ArrayList<String>(gameDevelopers.size());
      for (JsonElement el : gameDevelopers)
        gameDevelopersList.add(el.getAsJsonObject().get("name").getAsString());
      game.setDevelopers(gameDevelopersList);
    }

    JsonArray gamePlatform = ob.getAsJsonArray("platforms");
    if (gamePlatform != null)
    {
      List<String> gamePlatformList = new ArrayList<String>(gamePlatform.size());
      for (JsonElement el : gamePlatform)
        gamePlatformList.add(el.getAsJsonObject().get("name").getAsString());
      game.setPlatforms(gamePlatformList);
    }

    return game;
  }
}
