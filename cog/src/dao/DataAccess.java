/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import cog.Start;
import cog.models.AppConfigModel;
import cog.models.QuestionModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author dev-004
 */
public class DataAccess {

    public static AppConfigModel getGameConfig() {
        InputStream is = Start.class.getResourceAsStream("game_config.json");
        String json = convertStreamToString(is);
        Gson gson = new GsonBuilder().create();
        Type objType1 = TypeToken.getParameterized(AppConfigModel.class).getType();
        AppConfigModel data = gson.fromJson(json, objType1);        
        return data;
    }

    public static List<QuestionModel> getQuestions() {
        InputStream is = Start.class.getResourceAsStream("questions_source.json");
        String json = convertStreamToString(is);
        Gson gson = new GsonBuilder().create();
        Type objType1 = TypeToken.getParameterized(List.class, QuestionModel.class).getType();
        List<QuestionModel> list = gson.fromJson(json, objType1);
        return list;
    }

    static String convertStreamToString(java.io.InputStream is) {
        if (is == null) {
            return "";
        }

        java.util.Scanner s = new java.util.Scanner(is);
        s.useDelimiter("\\A");

        String streamString = s.hasNext() ? s.next() : "";

        s.close();

        return streamString;
    }
}
