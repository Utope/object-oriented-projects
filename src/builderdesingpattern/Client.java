/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builderdesingpattern;

/**
 *
 * @author robert
 */
public class Client {
    public static void main(String[] args){
        Waiter w1 = new Waiter();
        Waiter w2 = new Waiter();
        
        w1.setPizzaBuilder(new HawaiianPizzaBuilder());
        w2.setPizzaBuilder(new SpicyPizzaBuilder());
        
        w1.constructPizza();
        w2.constructPizza();
        
        Pizza[] pizzas = {w1.getPizza(), w2.getPizza()};
        
        for(Pizza pizza: pizzas){
            System.out.println(pizza.getDough());
            System.out.println(pizza.getSauce());
            System.out.println(pizza.getTopping());
        }
        
    }
}
