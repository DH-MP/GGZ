package com.ggz.model.activejdbc;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    ActiveJDBCImage imageUrl = new ActiveJDBCImage();

    imageUrl.setLargeUrl(imagesUrl.get("super_url").getAsString());
    imageUrl.setMediumUrl(imagesUrl.get("thumb_url").getAsString());
    imageUrl.setTinyUrl(imagesUrl.get("tiny_url").getAsString());

    game.setImagesUrl(imageUrl);

    JsonElement jel = ob.get("original_release_date");
    if (jel != null) game.setReleaseDate(jel.getAsString());

    JsonArray gameRating = ob.getAsJsonArray("original_game_rating");
    if (gameRating != null)
    {
      List<ActiveJDBCPGRating> gameRatingList = new ArrayList<>(gameRating.size());
      for (JsonElement el : gameRating)
      {
        ActiveJDBCPGRating rating = new ActiveJDBCPGRating();
        rating.setName(el.getAsJsonObject().get("name").getAsString());
        gameRatingList.add(rating);
      }

      game.setPgRating(gameRatingList);
    }

    JsonArray gameDevelopers = ob.getAsJsonArray("developers");
    if (gameDevelopers != null)
    {
      List<ActiveJDBCDeveloper> gameDevelopersList = new ArrayList<>(gameDevelopers.size());
      for (JsonElement el : gameDevelopers)
      {
        ActiveJDBCDeveloper dev = new ActiveJDBCDeveloper();
        dev.setName(el.getAsJsonObject().get("name").getAsString());
        gameDevelopersList.add(dev);
      }

      game.setDevelopers(gameDevelopersList);
    }

    JsonArray gamePlatform = ob.getAsJsonArray("platforms");
    if (gamePlatform != null)
    {
      List<ActiveJDBCPlatform> gamePlatformList = new ArrayList<>(gamePlatform.size());
      for (JsonElement el : gamePlatform)
      {
        ActiveJDBCPlatform platform = new ActiveJDBCPlatform();
        platform.setName(el.getAsJsonObject().get("name").getAsString());
        gamePlatformList.add(platform);
      }

      game.setPlatforms(gamePlatformList);
    }

    return game;
  }
}
