package com.example.myapplication;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Connenctionjson {

    public static List<FraseAPI> jsonDados(String frase) {
        try{
            List<FraseAPI> frases = new ArrayList<>();
            /*JSONObject jasonObject = null;
            JSONArray jsonArray = null;*/
            JSONObject jasonObject = new JSONObject(frase);
            String frase2 = jasonObject.getString("data");
            System.out.println("Json object retorno: " + frase2);
            JSONArray jsonArray = null;

            //jsonArray = new JSONArray(frase);
            //System.out.println("Json valor: " + jsonArray);

            /*for (int i = 0; i < jsonArray.length(); i++) {
                jasonObject = jsonArray.getJSONObject(i);

                FraseAPI fraseAPI = new FraseAPI();
                fraseAPI.setData(jasonObject.getString("data"));

                frases.add(fraseAPI);
            }*/
            jasonObject = jsonArray.getJSONObject(0);

            FraseAPI fraseAPI = new FraseAPI();
            fraseAPI.setData(jasonObject.getString("data"));

            frases.add(fraseAPI);


            return frases;


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
