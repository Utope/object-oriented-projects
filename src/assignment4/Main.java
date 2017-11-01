package assignment4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Menu menu = new Menu();
		
		menu.add(new MenuItem("Chicken", Menu.MAIN_DISH, false, 5.00f));
		menu.add(new MenuItem("Fried Chicken", Menu.MAIN_DISH, false, 6.00f));
		menu.add(new MenuItem("Grilled Chicken", Menu.MAIN_DISH, true, 8.00f));
		menu.add(new MenuItem("Burger", Menu.MAIN_DISH, true, 8.00f));
		
		menu.add(new MenuItem("Vanilla Ice Cream", Menu.DESSERT, false, 3.00f));
		menu.add(new MenuItem("Chocoalte Ice Cream", Menu.DESSERT, false, 3.00f));
		menu.add(new MenuItem("Strawberry Ice Cream", Menu.DESSERT, false, 3.00f));
		
		menu.add(new MenuItem("Fries", Menu.APPETIZERS, false, 1.00f));
		menu.add(new MenuItem("Chips", Menu.APPETIZERS, false, 2.00f));
		menu.add(new MenuItem("Potatoe", Menu.APPETIZERS, false, 2.00f));
		menu.add(new MenuItem("Vegies", Menu.APPETIZERS, true, 4.00f));
		
		
		
		
		menu.display();		
		
	}
	
	public static String takeInput(String prompt) {
		Scanner sc = new Scanner(System.in);
		System.out.println(prompt);
		return sc.nextLine();
	}
	
	public static void iterate(MenuIterator it) {
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void testPrint(Menu menu) {
		MenuIterator it;
		it = menu.AllItemsIterator();
		System.out.println("~~~ All Items Iterator ~~~");
		iterate(it);
		System.out.println();
		
		it = menu.HeartHealthyIterator(Menu.HEART_HEALTHY);
		System.out.println("~~~ HeartHealthyIterator (true) ~~~");
		iterate(it);
		System.out.println();
		
		it = menu.HeartHealthyIterator(Menu.NOT_HEART_HEALTHY);
		System.out.println("~~~ HeartHealthyIterator (false) ~~~");
		iterate(it);
		System.out.println();
		
		it = menu.ItemIterator(Menu.APPETIZERS);
		System.out.println("~~~ ItemIterator (APPETIZERS) ~~~");
		iterate(it);
		System.out.println();
		
		it = menu.ItemIterator(Menu.MAIN_DISH);
		System.out.println("~~~ ItemIterator (MAIN_DISH) ~~~");
		iterate(it);
		System.out.println();
		
		it = menu.ItemIterator(Menu.DESSERT);
		System.out.println("~~~ ItemIterator (DESSERT) ~~~");
		iterate(it);
		System.out.println();
		
		it = menu.PriceIterator(3.0f);
		System.out.println("~~~ PriceIterator (3.0f) ~~~");
		iterate(it);
		System.out.println();
		
		it = menu.PriceIterator(7.0f);
		System.out.println("~~~ PriceIterator (7.0f) ~~~");
		iterate(it);
		System.out.println();
		
		System.out.println("~~ Removing Items under 4$ ~~~");
		System.out.println("Before deletion...");
		it = menu.AllItemsIterator();
		iterate(it);
		System.out.println();
		
		menu.delete(menu.PriceIterator(4.0f));
		System.out.println("After deletion...");
		it = menu.AllItemsIterator();
		iterate(it);
		System.out.println();
	}
}
