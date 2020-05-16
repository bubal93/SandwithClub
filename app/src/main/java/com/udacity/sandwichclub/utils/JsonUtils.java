package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject sandwich = new JSONObject(json);
        JSONObject name = sandwich.getJSONObject("name");

        String mainName = name.getString("mainName");

        JSONArray alsoKnownAs = sandwich.getJSONArray("alsoKnownAs");
        List<String> knownAs = getStringList(alsoKnownAs);

        String placeOfOrigin = sandwich.getString("placeOfOrigin");

        String description = sandwich.getString("description");

        String image = sandwich.getString("image");

        JSONArray ingredientsArray = sandwich.getJSONArray("ingredients");
        List<String> ingredients = getStringList(ingredientsArray);

        return new Sandwich(mainName, knownAs, placeOfOrigin, description, image, ingredients);
    }

    private static List<String> getStringList(JSONArray array) throws JSONException {
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            strings.add(array.getString(i));
        }

        return strings;
    }
}
