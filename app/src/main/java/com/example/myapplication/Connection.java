package com.example.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//conexao com a api
public class Connection {
    static BufferedReader bufferedReader = null;

    public static String getDados(String uri) {
        try {
            URL url = new URL(uri);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            StringBuilder stringBuilder = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                stringBuilder.append(linha);
            }

            return stringBuilder.toString();


        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
