/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Beheerder.Pakket;
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
    private boolean isGreen;
    private Direction preStation;
    private Direction afterStation;
    private double calcPrice;

    public RouteCalculation(ArrayList<String> from, ArrayList<String> to, boolean isGreen){
        this.from = from;
        this.to = to;
        this.isGreen = isGreen;
        this.doCalls();
    }
    
    public void doCalls(){

        // Heenweg fietskoerier
        this.preStation = new Direction(from.get(1) + "%20" + from.get(2) + "%20" + from.get(0), from.get(0) + "%20station", "bicycling", "AIzaSyDGsj0SNnbYHEtz-Pr40fYKOrktoyQNz6s");        
        
        // api call 2
        this.afterStation = new Direction(to.get(0) + "%20station", to.get(1) + "%20" + to.get(2) + "%20" + to.get(0), "bicycling", "AIzaSyDGsj0SNnbYHEtz-Pr40fYKOrktoyQNz6s");        
        
        this.totalDistance = (preStation.getTravelDistance() / 1000) + (afterStation.getTravelDistance() / 1000);
        this.updateTotalPrice(true);
    }
    
    public void updateTotalPrice(boolean isGreen){
        if(isGreen){
            this.usingTrainTransport = true;       
            totalPrice = this.calculatePrice(preStation.getTravelDistance() / 1000) + 3.50 + (this.calculatePrice(afterStation.getTravelDistance() / 1000));
        }else{
            totalPrice = 20 + 3.50;
        }        
        System.out.println(this.totalPrice);

    }
    
    public double calculatePrice(double dik){ 
        if(dik < 4){
            this.calcPrice = 9;
        }else if(dik > 4 && dik < 25){
            this.calcPrice = 10;
        }else if(dik > 25 && dik < 31){
            this.calcPrice = (10+((dik - 25) * 0.39));
        }else if(dik > 31 && dik < 40){
            this.calcPrice = 12.50;
        }else if(dik > 40 && dik < 54.5){
            this.calcPrice = (10+((dik - 25) * 0.39));
        }
        
        return this.calcPrice;
    }
    
    public double getPrice(){
        ColorInConsole.output("red", "OUTPUT");
        System.out.println(this.totalPrice);
        return this.totalPrice;
    }
    
    public Boolean isUsingTrains(){
        return this.usingTrainTransport;
    }
}
