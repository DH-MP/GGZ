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
    game.set("api_id", ob.get("id").getAsInt());
    game.set("name", ob.get("name").getAsString());
    game.set("api_detail_url", ob.get("api_detail_url").getAsString());
    game.set("deck", ob.get("deck").getAsString());
    game.set("description", ob.get("description").getAsString());
    game.save();

    JsonObject imagesUrl = ob.getAsJsonObject("image");
    ActiveJDBCImage imageUrl = new ActiveJDBCImage();

    imageUrl.set("large_url", imagesUrl.get("super_url").getAsString());
    imageUrl.set("medium_url", imagesUrl.get("thumb_url").getAsString());
    imageUrl.set("tiny_url", imagesUrl.get("tiny_url").getAsString());

    game.add(imageUrl);

    JsonElement jel = ob.get("original_release_date");
    if (jel != null) game.set("release_date", jel.getAsString());

    JsonArray gameRating = ob.getAsJsonArray("original_game_rating");
    if (gameRating != null)
    {
      for (JsonElement el : gameRating)
      {
        ActiveJDBCPGRating rating = new ActiveJDBCPGRating();
        rating.set("name", el.getAsJsonObject().get("name").getAsString());
        game.add(rating);
      }
    }

    JsonArray gameDevelopers = ob.getAsJsonArray("developers");
    if (gameDevelopers != null)
    {
      for (JsonElement el : gameDevelopers)
      {
        ActiveJDBCDeveloper dev = new ActiveJDBCDeveloper();
        dev.set("name", el.getAsJsonObject().get("name").getAsString());
        game.add(dev);
      }
    }

    JsonArray gamePlatform = ob.getAsJsonArray("platforms");
    if (gamePlatform != null)
    {
      for (JsonElement el : gamePlatform)
      {
        ActiveJDBCPlatform platform = new ActiveJDBCPlatform();
        platform.set("name", el.getAsJsonObject().get("name").getAsString());
        game.add(platform);
      }
    }

    game.save();
    return game;
  }
}
