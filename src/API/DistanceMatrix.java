/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author thomhofstede
 */
public class DistanceMatrix {
    private final String origin;
    private final String destination;
    private final String mode;
    private final String APIKey;
    private final double minDistanceInMeters = 25000.5;
    private Request req;
    private JSONObject result;
        
    public DistanceMatrix(ArrayList origins, ArrayList destinations, String mode, String APIKey){
        String s_origins = "";
        String s_destinations = "";
        
        for(Object origin: origins){
            if(origins.indexOf(origin) == (origins.size() - 1)){
                s_origins += origin;
            }else{
                s_origins += origin + "+";
            }
        }
        
        for(Object destination: destinations){
            if(destinations.indexOf(destination) == (destinations.size() - 1)){
                s_destinations += destination;
            }else{
                s_destinations += destination + "+";
            }
        }
                
        this.origin = s_origins;
        this.destination = s_destinations;
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
    
    public boolean isProfitable(){
        return this.getTravelDistance() > minDistanceInMeters;
    }
}
