package assignment4;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
	
	enum MenuState{
		Main
	}
	
	public static final int APPETIZERS = 1;
	public static final int MAIN_DISH = 2;
	public static final int DESSERT = 3;
	
	public static final boolean HEART_HEALTHY = true;
	public static final boolean NOT_HEART_HEALTHY = false;
	
	private ArrayList<MenuItem> items;
	
	private String mainMenu;
	
	public Menu() {
		items = new ArrayList<>();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" ~~~ Menu ~~~\n");
		stringBuilder.append("1 - Display all menu items\n");
		stringBuilder.append("2 - Display all appetizers\n");
		stringBuilder.append("3 - Display all main dishes\n");
		stringBuilder.append("4 - Display all desserts\n");
		stringBuilder.append("5 - Display all hearty healthy items\n");
		stringBuilder.append("6 - Display all main dishes under a specified price\n");
		stringBuilder.append("7 - Add menu item\n");
		stringBuilder.append("8 - remove menu item\n");
		this.mainMenu = stringBuilder.toString();
	}
	
	public void add(MenuItem item) {
		items.add(item);
	}
	
	public void delete(MenuIterator it) {
		while(it.hasNext()) {
			items.remove(it.next());
		}
	}
	
	public void delete(MenuItem item) {
		items.remove(item);
	}
	
	public void display() {
		Scanner sc = new Scanner(System.in);
		
		boolean cont = true;
		do {
			System.out.println(this.mainMenu);
			
			String input;
			int value = 0;
			System.out.print("Select: ");
			input = sc.nextLine();
			
			try {
				value = Integer.parseInt(input);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			MenuIterator it;
			switch(value) {
			case 1:
				System.out.println("~~~ Displaying All items ~~~");
				printMenuIterator(this.AllItemsIterator());
				break;
			case 2:
				System.out.println("~~~ Displaying All Appetizers ~~~");
				printMenuIterator(this.ItemIterator(APPETIZERS));
				break;
			case 3:
				System.out.println("~~~ Displaying All Main Dishes items ~~~");
				printMenuIterator(this.ItemIterator(MAIN_DISH));
				break;
			case 4:
				System.out.println("~~~ Displaying All Desserts items ~~~");
				printMenuIterator(this.ItemIterator(DESSERT));
				break;
			case 5:
				System.out.println("~~~ Displaying All Heart Healthy items ~~~");
				printMenuIterator(this.HeartHealthyIterator(HEART_HEALTHY));
				break;
			case 6:

				boolean correctInput = true;
				do {
					String priceString = "";
					float priceValue = 0;
					System.out.print("Input price:");
					priceString = sc.nextLine();
					
					try {
						priceValue = Float.parseFloat(priceString);
						System.out.println("~~~ Displaying all items under " + priceValue + " ~~~");
						printMenuIterator(this.PriceIterator(priceValue));
						correctInput = false;
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}while(correctInput);
				break;
			case 7:
				
				String name;
				int category;
				boolean heartHealthy = false;
				float price;
				
				System.out.println("~~~ Adding item New Menu Item ~~~");
				System.out.println("Input name:");
				name = sc.nextLine();
				System.out.println("Input category(APPETIZERS=1, MAIN_DISH=2, DESERT=3)");
				category = Integer.valueOf(sc.nextLine());
				System.out.println("Is Heart Healthy(y,n):");
				
				String hhchar = sc.nextLine();
				if(hhchar.equals("y")) {
					heartHealthy = true;
				}else if(hhchar.equals("n")) {
					heartHealthy = false;
				}
				
				System.out.println("Input Price");
				price = Float.valueOf(sc.nextLine());
				
				this.items.add(new MenuItem(name,category,heartHealthy,price));
				System.out.println("Item succesfully added!");
				
				
				break;
			case 8:
				
				System.out.println("~~~ Deleting items ~~~");
				for(int i = 0; i < this.items.size(); i++) {
					System.out.println("[" + i + "]" + items.get(i));
				}
				
				System.out.println("Enter index of item you want to delete:");
				
				int index = Integer.valueOf(sc.nextLine());
				
				this.delete(items.get(index));
				
				System.out.println("Item succesfully deleted");
				
				break;
			}
			
			System.out.println();
			System.out.print("Enter 'q' to quit otherwise return to main menu...");
			if("q".equals(sc.nextLine())){
				cont = false;
			}
			System.out.println();
			
		}while(cont);
		
		sc.close();
	}
	
	public void printMenuIterator(MenuIterator it) {
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public String prompt(String prompt){
		Scanner sc = new Scanner(System.in);
		System.out.println(prompt);
		return sc.nextLine();
	}
	public MenuIterator AllItemsIterator(){
		return new AllItemsIterator();
	}
	
	public MenuIterator ItemIterator(int category){
		return new ItemIterator(category);
	}
	
	public MenuIterator HeartHealthyIterator(boolean heartHealthy){
		return new HeartHealthyIterator(heartHealthy);
	}
	
	public MenuIterator PriceIterator(float highestPrice){
		return new PriceIterator(highestPrice);
	}
	
	
	
	// ITERATOR LIST //
	
	class AllItemsIterator implements MenuIterator{
		int counter;
		
		public AllItemsIterator() {
			this.counter = 0;
		}
		
		@Override
		public boolean hasNext() {
			if(counter < items.size()) {
				return true;
			}else {
				return false;
			}
		}

		@Override
		public MenuItem next() {
			if(hasNext()) {
				return items.get(counter++);
			}else {
				throw new NoSuchElementException();
			}
		}
		
	}
	
	class ItemIterator implements MenuIterator{
		
		int counter;
		int category;
		
		public ItemIterator(int category) {
			this.counter = 0;
			this.category = category;
		}
		
		@Override
		public boolean hasNext() {
			while(counter < items.size()) {
				if(items.get(counter).getCategory() == category) {
					return true;
				}else {
					counter++;
				}
			}
			return false;
		}

		@Override
		public MenuItem next() {
			if(hasNext()) {
				return items.get(counter++);
			}else {
				throw new NoSuchElementException();
			}
		}
		
	}
	
	class HeartHealthyIterator implements MenuIterator{
		
		int counter;
		boolean isHealthy;
		
		public HeartHealthyIterator(boolean heartHealthy){
			this.counter = 0;
			this.isHealthy = heartHealthy;
		}
		@Override
		public boolean hasNext() {
			while(counter < items.size()) {
				if(items.get(counter).isHeartHealthy() == isHealthy) {
					return true;
				}else {
					counter++;
				}
			}
			return false;
		}

		@Override
		public MenuItem next() {
			if(hasNext()) {
				return items.get(counter++);
			}else {
				throw new NoSuchElementException();
			}
		}
		
	}
	
	class PriceIterator implements MenuIterator{
		
		int counter;
		float highestPrice;
		
		public PriceIterator(float highestPrice) {
			this.counter = 0;
			this.highestPrice = highestPrice;
		}
		
		@Override
		public boolean hasNext() {
			while(counter < items.size()) {
				if(items.get(counter).getPrice() < highestPrice) {
					return true;
				}else {
					counter++;
				}
			}
			return false;
		}

		@Override
		public MenuItem next() {
			if(hasNext()) {
				return items.get(counter++);
			}else {
				throw new NoSuchElementException();
			}
		}
		
	}
}
