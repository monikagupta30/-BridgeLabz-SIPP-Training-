import java.util.ArrayList;
import java.util.List;

// Abstract class WarehouseItem
abstract class WarehouseItem {
	private String name;
	
	public WarehouseItem(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract String getCategory();
	
	@Override
	public String toString() {
		return getCategory() + ": " + name;
	}
}

// Subclasses of WarehouseItem
class Electronics extends WarehouseItem {
	public Electronics(String name) {
		super(name);
	}
	
	@Override
	public String getCategory() {
		return "Electronics";
	}
}

class Groceries extends WarehouseItem {
	public Groceries(String name) {
		super(name);
	}
	
	@Override
	public String getCategory() {
		return "Groceries";
	}
}

class Furniture extends WarehouseItem {
	public Furniture(String name) {
		super(name);
	}
	
	@Override
	public String getCategory() {
		return "Furniture";
	}
}

// Generic class Storage<T extends WarehouseItem>
class Storage<T extends WarehouseItem> {
	private List<T> items = new ArrayList<>();
	
	public void addItem(T item) {
		items.add(item);
	}
	
	public List<T> getItems(){
		return items;
	}
	
	public void displayItems() {
		for(T item : items) {
			System.out.println(item);
		}
	}
}

// Wildcard method to display any storage contents
class WarehouseUtils {
	public static void displayAllItems(List<? extends WarehouseItem> items) {
		for(WarehouseItem item : items) {
			System.out.println(item);
		}
	}
}

// Main method to test the system
public class SmartWarehouseSystem {
	public static void main(String[] args) {
		Storage<Electronics> electronicsStorage = new Storage<>();
		electronicsStorage.addItem(new Electronics("Laptop"));
		electronicsStorage.addItem(new Electronics("Smartphone"));
		
		Storage<Groceries> groceriesStorage = new Storage<>();
		groceriesStorage.addItem(new Groceries("Rice"));
		groceriesStorage.addItem(new Groceries("Milk"));
		
		Storage<Furniture> furnitureStorage = new Storage<>();
	    furnitureStorage.addItem(new Furniture("Chair"));
	    furnitureStorage.addItem(new Furniture("Table"));
	    
	    System.out.println("== Electronics Storage ==");
	    electronicsStorage.displayItems();
	    
	    System.out.println("\n== Groceries Storage ==");
	    groceriesStorage.displayItems();
	    
	    System.out.println("\n== Furniture Storage ==");
	    furnitureStorage.displayItems();
	    
	    System.out.println("\n== Display All Using Wildcard Method ==");
        WarehouseUtils.displayAllItems(electronicsStorage.getItems());
        WarehouseUtils.displayAllItems(groceriesStorage.getItems());
        WarehouseUtils.displayAllItems(furnitureStorage.getItems());

	}
}








































