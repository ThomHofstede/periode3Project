/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API_directions;




/**
 *
 * @author thomhofstede
 */
public class RequestTest {
    public static void main(String[] args){

        Direction req1 = new Direction("zwolle", "deventer", "transit", "AIzaSyDGsj0SNnbYHEtz-Pr40fYKOrktoyQNz6s");
            
        System.out.println(req1.getTravelDuration());                    
    }
    
}
