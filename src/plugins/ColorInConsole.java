/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thomhofstede
 */
public class ColorInConsole {
    public static final String ANSI_RESET = "\u001B[0m";
    public Map<String, String> colors = new HashMap<>();
    
    public ColorInConsole(){
        colors.put("red", "\u001B[31m");
        colors.put("black", "\u001B[30m");
        colors.put("green", "\u001B[32m");
        colors.put("yellow", "\u001B[33m");
        colors.put("blue", "\u001B[34m");
        colors.put("purple", "\u001B[35m");
        colors.put("cyan", "\u001B[36m");
        colors.put("white", "\u001B[37m");
    }
    
    public void output(String color, String message){
        if(colors.containsKey(color)){
            System.out.println(colors.get(color) + message + ANSI_RESET);
        }else{
            System.out.println(colors.get("red") + "Color was not found! Available colors: black/red/green/yellow/blue/purple/cyan/white ." + ANSI_RESET);
        }
    }
}
