/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

/**
 *
 * @author robert
 */
public class DisplayTab implements Command {
    
    Restaurant restaurant;
    
    public DisplayTab(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    
    @Override
    public void exectue() {
        System.out.println(restaurant.getTab());
    }
    
}
