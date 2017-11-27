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
public class HawaiianPizzaBuilder extends PizzaBuilder {

    @Override
    public void buildDough() {
        pizza.setDough("Pinapple dough");
    }

    @Override
    public void buildSauce() {
         pizza.setSauce("Pinapple sauce");
    }

    @Override
    public void buildTopping() {
       pizza.setTopping("Pinapples");
    }
    
}
