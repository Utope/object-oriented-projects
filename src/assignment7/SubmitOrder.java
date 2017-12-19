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
public class SubmitOrder implements Command {

    Restaurant restaurant;
    
    public SubmitOrder(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    
    @Override
    public void exectue() {
        System.out.println("Your order has been submited!");
        System.out.println("A new order has been started!");
        restaurant.getOrders().getOrderItems().clear();
    }
    
}
