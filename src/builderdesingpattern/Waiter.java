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
public class Waiter {
    private PizzaBuilder pizzaBuilder;
    
    public void setPizzaBuilder(PizzaBuilder pb){
       this.pizzaBuilder = pb;
    }
    
    public Pizza getPizza(){
        return this.pizzaBuilder.getPizza();
    }
    
    public void constructPizza(){
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}
