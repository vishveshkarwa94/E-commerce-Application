package com.online.shopping.AttributeConverter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonToMapConverter
{
    public static Map<String, Object> productSpecificationStringConverter(String JsonString) {
        JSONObject obj = new JSONObject(JsonString);
        Map<String, Object> productSpecificationObject = new HashMap<>();
        JSONObject insideObj = (JSONObject)obj.get("product_specification");
        for( String key : insideObj.keySet()){
            productSpecificationObject.put(key,insideObj.get(key));
        }

        return productSpecificationObject;
    }

    public static List<Object> ImageStringConverter(String JsonString) {
        JSONObject obj = new JSONObject(JsonString);
        JSONArray array = obj.getJSONArray("images");
        return array.toList();
    }


}
