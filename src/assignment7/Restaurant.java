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
public class Restaurant {
    private static Restaurant restaurant = new Restaurant();
    
    private Orders orders;
    private Menu menu;
    
    Command displayMenu;
    Command displayTab;
    Command submitOrder;
    
    private Restaurant(){
        
        orders = new Orders();
        menu = new Menu();
        
        this.displayMenu = new DisplayMenu(this);
        this.displayTab = new DisplayTab(this);
        this.submitOrder = new SubmitOrder(this);
        
        this.initMenu();
    }
    
    private void initMenu(){
        addMenuItem("Soda", 3);
        addMenuItem("Water", 0);
        addMenuItem("Wine", 7);
        addMenuItem("Beer", 3.50f);
        addMenuItem("Burger", 7);
        addMenuItem("CheeseBurger", 7.75f);
        addMenuItem("Roast Beef", 10);
        addMenuItem("Salmon", 12);
        addMenuItem("Steak", 17);
    }
    
    public static Restaurant Instance(){
        return restaurant;
    }
    
    public Orders getOrders(){
        return this.orders;
    }
    
    public Menu getMenu(){
        return this.menu;
    }
    
    public Tab getTab(){
        return new Tab(this.orders);
    }
    
    public boolean addMenuItem(String name, float price){
        
        if(!menu.contains(name)){
            this.menu.getMenuItems().add(new MenuItem(name,price));
            return true;
        }else{
            return false;
        }
    }
    
    public boolean addOrderItem(String name){
        if(menu.contains(name)){
            this.orders.getOrderItems().add(new OrderItem(this.getMenu().get(name)));
            return true;
        }
        return false;
    }
    
    public void displayMenu(){
        this.displayMenu.exectue();
    }
    
    public void displayTab(){
        this.displayTab.exectue();
    }
    
    public void submitOrder(){
        this.submitOrder.exectue();
    }
    
    
}
