/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.util.ArrayList;
import java.util.Random;




/**
 *
 * @author thomhofstede
 */
public class RequestTest {
    public static void main(String[] args){
        
//        ArrayList<String> origins = new ArrayList<String>();
//        ArrayList<String> destinations = new ArrayList<String>();
//
//        origins.add("zwolle");
//        origins.add("raalte");
//        
//        destinations.add("amsterdam");
//        destinations.add("enschede");
//        
//        DistanceMatrix req1 = new DistanceMatrix(origins, destinations, "transit", "AIzaSyDGsj0SNnbYHEtz-Pr40fYKOrktoyQNz6s");
//            
        

       // Direction req1 = new Direction("zwolle", "deventer", "transit", "AIzaSyDGsj0SNnbYHEtz-Pr40fYKOrktoyQNz6s");
//            
       // System.out.println(req1.getTravelDuration());
       
       Random generator = new Random(); 
        int i = generator.nextInt(100000);
        System.out.println(i);
    }
    
}
