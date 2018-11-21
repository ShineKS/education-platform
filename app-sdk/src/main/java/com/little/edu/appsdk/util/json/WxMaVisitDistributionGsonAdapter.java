package com.little.edu.appsdk.util.json;

import com.google.gson.*;
import com.little.edu.appsdk.bean.analysis.WxMaVisitDistribution;
import me.chanjar.weixin.common.util.json.GsonHelper;

import java.lang.reflect.Type;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/charmingoh">Charming</a>
 * @since 2018-04-28
 */
public class WxMaVisitDistributionGsonAdapter implements JsonDeserializer<WxMaVisitDistribution> {
  @Override
  public WxMaVisitDistribution deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
    if (json == null) {
      return null;
    }

    WxMaVisitDistribution distribution = new WxMaVisitDistribution();
    JsonObject object = json.getAsJsonObject();
    String refDate = GsonHelper.getString(object, "ref_date");
    distribution.setRefDate(refDate);

    boolean hasList = object.has("list");
    if (!hasList) {
      return distribution;
    }

    JsonArray listArray = object.getAsJsonArray("list");
    Map<String, Map<Integer, Integer>> list = new Hashtable<>(listArray.size());
    for (JsonElement indexElement : listArray) {
      JsonObject indexObject = indexElement.getAsJsonObject();
      String index = GsonHelper.getString(indexObject, "index");
      if (index == null) {
        continue;
      }

      Map<Integer, Integer> itemList = new LinkedHashMap<>();
      JsonArray itemArray = indexObject.getAsJsonArray("item_list");
      if (itemArray == null || itemArray.size() <= 0) {
        list.put(index, itemList);
        continue;
      }

      for (JsonElement itemElement : itemArray) {
        JsonObject itemObject = itemElement.getAsJsonObject();
        Integer key = GsonHelper.getInteger(itemObject, "key");
        Integer value = GsonHelper.getInteger(itemObject, "value");
        if (key != null) {
          itemList.put(key, value);
        }
      }
      list.put(index, itemList);
    }
    distribution.setList(list);
    return distribution;
  }
}
