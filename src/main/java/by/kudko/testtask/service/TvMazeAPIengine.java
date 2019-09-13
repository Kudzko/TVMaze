package by.kudko.testtask.service;


import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import by.kudko.testtask.model.TVShow;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TvMazeAPIengine {
    public final static String URL_SEARCH = "http://api.tvmaze.com/search/shows?q=";

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = (new JSONArray(jsonText));
            return json;
        } finally {
            is.close();
        }
    }

    public static List<TVShow> search(String input) throws IOException,
            JSONException {
        String searchRequest = URL_SEARCH + input;
        System.out.println(searchRequest);
        String result = "no result";
        JSONArray jsonArray = readJsonFromUrl(searchRequest);

//        result = json.toString();
//        System.out.println(json.toString());
//        System.out.println();
//        System.out.println();
//        System.out.println(json.keys());
        return toJavaObjects(jsonArray);

    }

    public static List<TVShow> toJavaObjects(JSONArray jsonArray){
        List<TVShow> javaObjects = new ArrayList<TVShow>();
        TVShow tvShow;

        for (int i = 0; i < jsonArray.length(); i++){
            tvShow = new TVShow();
            tvShow.setTitle(Double.toString(jsonArray.getJSONObject(i).getDouble
                    ("score")));
            tvShow.setName(jsonArray.getJSONObject(i).getJSONObject("show").getString("name"));
            tvShow.setCastInformation(jsonArray.getJSONObject(i)
                    .getJSONObject("show").getString("url"));
            tvShow.setBirthDay(jsonArray.getJSONObject(i).getJSONObject
                    ("show").get("premiered").toString());
            tvShow.setId(jsonArray.getJSONObject(i).getJSONObject("show")
                    .getInt("id"));
            javaObjects.add(tvShow);
        }

        return javaObjects;
    }

}
