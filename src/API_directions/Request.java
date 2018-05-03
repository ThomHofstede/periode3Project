/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API_directions;

import plugins.ColorInConsole;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author thomhofstede
 * AIzaSyDGsj0SNnbYHEtz-Pr40fYKOrktoyQNz6s <--- map directions API key
 */
public class Request{
    
    private String url;
    private JSONObject result = new JSONObject();

    private ColorInConsole cic = new ColorInConsole();

    public Request(String url){
        if(!url.isEmpty()){
            this.url = url;
            this.doHttpRequest();
        }
    }
    
    private void doHttpRequest() {
        try{
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            
            if(con.getResponseCode() == 200){
                StringBuilder response;
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    response = new StringBuilder();
                    while((inputLine = in.readLine()) != null){
                        response.append(inputLine);
                    }
                }
                JSONParser parser = new JSONParser();
                String re = response.toString();
                JSONObject json = (JSONObject) parser.parse(re);
                this.result = json;
                               
                cic.output("green",  "Successful call to  " + url + ".");
            }else{
                cic.output("red", "Response code: " + con.getResponseCode());
            }
            
        }catch(IOException | ParseException e){
            cic.output("red", e.toString());
        }
        
    }
    
    public JSONObject getJSONResult(){
        return this.result;
    }
    
    public boolean hasJSONResult(){
        if(this.result != null){
            return true;
        }else{
            return false;
        }
    }
}
