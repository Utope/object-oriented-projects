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
abstract class PizzaBuilder {
    protected Pizza pizza;
    
    public Pizza getPizza(){
        return this.pizza;
    }
    
    public void createNewPizzaProduct(){
        pizza = new Pizza();
    }
    
    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}
