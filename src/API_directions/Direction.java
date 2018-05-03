/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API_directions;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 *
 * @author thomhofstede
 */
public class Direction{
    
    private String origin;
    private String destination;
    private String mode;
    private String APIKey;
    private Request req;
    private JSONObject result;
        
    public Direction(String origin, String destination, String mode, String APIKey){
        this.origin = origin;
        this.destination = destination;
        this.mode = mode;
        this.APIKey = APIKey;
    }
    
    private String generateURL(){
        if(!origin.isEmpty() && !destination.isEmpty() && !mode.isEmpty() && !APIKey.isEmpty()){
            return "https://maps.googleapis.com/maps/api/directions/json?origin="+origin+"&destination="+destination+"&mode=" + mode +"&key=" + APIKey;
        }else{
            return null;
        }
    }
    
    public JSONObject getData(){
        this.req = new Request(this.generateURL());
        
        System.out.println(this.req);
        if(this.req.hasJSONResult()){
            return this.req.getJSONResult();
        }else{
            return null;
        }
    }
    
    public long getTravelDistance(){
        long distance;
        this.result = this.getData();
   
        try{
            JSONArray arras = (JSONArray)result.get("routes");
            JSONObject route = (JSONObject)arras.get(0);
            JSONArray legs = (JSONArray)route.get("legs");
            JSONObject legs_array = (JSONObject)legs.get(0);
            JSONObject distanceObject = (JSONObject)legs_array.get("distance");
            
            distance = (long) distanceObject.get("value");
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }
        
        return distance;
    }
    
    public long getTravelDuration(){   
        long duration;
        this.result = this.getData();
   
        try{
            JSONArray arras = (JSONArray)result.get("routes");
            JSONObject route = (JSONObject)arras.get(0);
            JSONArray legs = (JSONArray)route.get("legs");
            JSONObject legs_array = (JSONObject)legs.get(0);
            JSONObject durationObject = (JSONObject)legs_array.get("duration");
            
            duration = (long) durationObject.get("value");
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }
        
        return duration;
    }
}
