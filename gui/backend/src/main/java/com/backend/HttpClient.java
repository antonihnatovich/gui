package com.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {
    public String get(String url){
        String responce = null;
        try{
            URL reqUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)reqUrl.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            while((responce = reader.readLine()) != null){
                builder.append(responce);
            }
            responce = builder.toString();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return responce;
    }
}
