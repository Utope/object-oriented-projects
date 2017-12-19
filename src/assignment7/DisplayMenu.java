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
public class DisplayMenu implements Command {
    
    Restaurant restaurant;
    
    public DisplayMenu(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    
    @Override
    public void exectue() {
        System.out.println("~~~ Menu ~~~");
        for(MenuItem item : restaurant.getMenu().getMenuItems()){
            System.out.println(item);
        }
    }
    
}
