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
public class SpicyPizzaBuilder extends PizzaBuilder {

    @Override
    public void buildDough() {
        pizza.setDough("Spicy boi dough");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("Spicy boi sauce");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("Spicy boi topping");
    }
    
}
