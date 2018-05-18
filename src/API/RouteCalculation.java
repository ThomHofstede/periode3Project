/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.util.ArrayList;
import plugins.ColorInConsole;

/**
 *
 * @author thomhofstede
 */

public final class RouteCalculation {
    private final ArrayList<String> from;
    private final ArrayList<String> to;
    private final boolean status = false;
    private final ArrayList<String> data = new ArrayList<>();
    public ColorInConsole cic;
    private double totalPrice = 0.0;
    private Boolean usingTrainTransport = false;
    private long totalDistance = 0;

    public RouteCalculation(ArrayList<String> from, ArrayList<String> to){
        this.from = from;
        this.to = to;
        
        this.doCalls();
    }
    
    public void doCalls(){
        // Heenweg fietskoerier
        Direction preStation = new Direction(from.get(1) + "%20" + from.get(2) + "%20" + from.get(0), from.get(0) + "%20station", "bicycling", "AIzaSyDGsj0SNnbYHEtz-Pr40fYKOrktoyQNz6s");        
        
        // api call 3
        Direction afterStation = new Direction(to.get(0) + "%20station", "bicycling", to.get(1) + "%20" + to.get(2) + "%20" + to.get(0), "AIzaSyDGsj0SNnbYHEtz-Pr40fYKOrktoyQNz6s");        
        
        this.totalDistance = (preStation.getTravelDistance() / 1000) + (afterStation.getTravelDistance() / 1000);
        if(this.totalDistance > 54.5){
            this.usingTrainTransport = true;
            totalPrice += this.calculatePrice(preStation.getTravelDistance() / 1000) + 3.50 + this.calculatePrice(afterStation.getTravelDistance() / 1000);
        }
    }
    
    public double calculatePrice(double dik){
        double price = 0;
        if(this.usingTrainTransport){
            price = (10+((dik - 25) * 0.39));
        }else{
            if(dik < 4){
                price = 9;
            }else if(dik > 4 && dik < 25){
                price = 10;
            }else if(dik > 25 && dik < 31){
                price = (10+((dik - 25) * 0.39));
            }else if(dik > 31 && dik < 40){
                price = 12.50;
            }else if(dik > 40 && dik < 54.5){
                price = (10+((dik - 25) * 0.39));
            }
        }
        
        return price;
    }
    
    public double getPrice(){
        return this.totalPrice;
    }
    
    public Boolean isUsingTrains(){
        return this.usingTrainTransport;
    }
}
