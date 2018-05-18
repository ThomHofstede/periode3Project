/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.util.ArrayList;
import java.util.HashMap;
import plugins.ColorInConsole;

/**
 *
 * @author thomhofstede
 */
public class RouteCalculation {
    private ArrayList<String> from;
    private ArrayList<String> to;
    private boolean status = false;
    private ArrayList<String> data = new ArrayList<>();
    public ColorInConsole cic;
    private double totalPrice = 0.0;

    public RouteCalculation(ArrayList<String> from, ArrayList<String> to){
        this.from = from;
        this.to = to;
        
        this.doCalls();
    }
    
    public void doCalls(){
        // Heenweg fietskoerier
        Direction preStation = new Direction(from.get(1) + "%20" + from.get(2) + "%20" + from.get(0), from.get(0) + "%20station", "bicycling", "AIzaSyDGsj0SNnbYHEtz-Pr40fYKOrktoyQNz6s");        
        long distanceInKM = preStation.getTravelDistance() / 1000;
        
        if(distanceInKM < 25 ){
            totalPrice += 10;
        }else if(distanceInKM> 25 && distanceInKM < 40){
            totalPrice += 12.50;
        }else{
            long difference = distanceInKM - 40;
            totalPrice+= 12.50 + (difference * 0.40);
        }
        
        // Trein koerier (vast bedrag)
        totalPrice += 3.50;
        
        // api call 3
        Direction afterStation = new Direction(to.get(0) + "%20station", "bicycling", to.get(1) + "%20" + to.get(2) + "%20" + to.get(0), "AIzaSyDGsj0SNnbYHEtz-Pr40fYKOrktoyQNz6s");        
        long distanceInKM2 = afterStation.getTravelDistance() / 1000;
        
        if(distanceInKM2 < 25 ){
            totalPrice += 10;
        }else if(distanceInKM2> 25 && distanceInKM2 < 40){
            totalPrice += 12.50;
        }else{
            long difference2 = distanceInKM2 - 40;
            totalPrice+= 12.50 + (difference2 * 0.40);
        }
        // set status true if all is correct
        
        System.out.println(totalPrice);
        
    }
    
    public double getPrice(){
        return this.totalPrice;
    }
}
