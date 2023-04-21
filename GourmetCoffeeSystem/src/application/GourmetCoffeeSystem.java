package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.NumberFormat;



import base.Catalog;
import base.Coffee;
import base.CoffeeAccessory;
import base.CoffeeBrewer;
import base.Order;
import base.Sales;
import base.OrderItem;



public class GourmetCoffeeSystem{
  
	private static BufferedReader stdIn=
            new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdOut=
            new PrintWriter(System.out,true);
    private PrintWriter stdErr=
            new PrintWriter(new PrintWriter(System.err,true));
    private static final NumberFormat CURRENCY=
            NumberFormat.getCurrencyInstance();

    private Catalog catalog;
    private Order order;
    private Sales sales;
	public GourmetCoffeeSystem() throws IOException{
		super();
		this.catalog = initCatalog();
		this.order = new Order();
		this.sales = loadSals();
	}
	private Catalog initCatalog() {
    	Catalog catalog = new Catalog();
    	
    	catalog.addProduct(new Coffee("C001","Colombia, Whole, 1 lb",17.99, "Colombia","Medium","Rich and Hearty","Rich","Medium","Full","Coconut"));
        catalog.addProduct(new Coffee("C002","Colombia, Ground, 1 lb",18.75, "Colombia","Medium","Rich and Hearty","Rich","Medium","Full","Nothing"));
        catalog.addProduct(new Coffee("C003","Guatemala, Whole, 1 lb",17.99, "Guatemala","Medium","Rich and complex","Spicy","Medium to high","Medium to full","Coconut"));
        catalog.addProduct(new Coffee("C004","Guatemala, Ground, 1 lb",18.75, "Guatemala","Medium","Rich and complex","Spicy","Medium to high","Medium to full","Nothing"));
        
        catalog.addProduct(new CoffeeBrewer("B001","Home Coffee Brewer",150.00, "Brewer 100","Pourover",6));
        catalog.addProduct(new CoffeeBrewer("B002","Coffee Brewer, 2 Warmers",200.00, "Brewer 200","Pourover",12));
        catalog.addProduct(new CoffeeBrewer("B003","Coffee Brewer, 3 Warmers",280.00, "Brewer 210","Pourover",12));
        catalog.addProduct(new CoffeeBrewer("B004","Commercial Brewers, 20 Cups",380.00, "Quick Coffee 100","Automatic",20));
        catalog.addProduct(new CoffeeBrewer("B005","Commercial Brewers, 40 Cups",480.00, "Quick Coffee 200","Automatic",40));

        catalog.addProduct(new CoffeeAccessory("A001","Almond Flavored Syrup",9.00));
        catalog.addProduct(new CoffeeAccessory("A002","Irish Creme Flavored Syrup",9.00));
        catalog.addProduct(new CoffeeAccessory("A003","Gourment Coffee Cookies",12.00));
        catalog.addProduct(new CoffeeAccessory("A004","Gourmet Coffee Geramic Mug",8.00));
        catalog.addProduct(new CoffeeAccessory("A005","Gourmet Coffee 36 Cup Filters",45.00));
    	
    	return catalog;
    }
	
	private Sales loadSals() {
		Sales sales = new Sales();
		
		return sales;
	}
	
	public static void main(String[] args) throws IOException {
		GourmetCoffeeSystem application = new GourmetCoffeeSystem();
		application.run();
	}
    
	private void run() throws IOException {
		 int choice = getChoice();

	        while (choice != 0){
	            if (choice == 1)        displayCatalog();
	            else if (choice == 2)   displayProduct();
	            else if (choice == 3)   displayCurrentOrder();
	            else if (choice == 4)   addProduct();
	            else if (choice == 5)   removeProdcut();
	            else if (choice == 6)   registerCurrentOrder();
	            else if (choice == 7)   displaySals();
	            else if (choice == 8)   addCatalog();
	            else if (choice == 9)   removeCatalog();

	            choice = getChoice();
	        }
		
	}

	private int getChoice() throws IOException {
		 int input;

	        do {
	            try {
	                stdErr.println();
	                stdErr.print(     "[0] Quit\n"
	                                + "[1] Display catalog\n"
	                                + "[2] Display product\n"
	                                + "[3] Display current order\n"
	                                + "[4] Add product to current order\n"
	                                + "[5] Remove product from current order\n"
	                                + "[6] Register sale of current order\n"
	                                + "[7] Display sales\n"
	                                + "[8] Add new coffeeaccessory to catalog\n"
	                                + "[9] Remove coffeeaccessory from catalog\n"
	                                + "choice> ");
	                stdErr.flush();

	                input = Integer.parseInt(stdIn.readLine());

	                stdErr.println();

	                if(0 <= input && 7 >= input){
	                    break;
	                }else {
	                    stdErr.println("Invalid choice: " + input);
	                }
	            }catch (NumberFormatException nfe){
	                stdErr.println(nfe);
	            }
	        }while (true);

	        return input;
	}

	
    
	private void displayCatalog() {
		int size = this.catalog.getNumberOfProducts();

        if (size == 0){
            stdErr.println("The catalog is empty");
        }else {
            for (CoffeeAccessory coffeeAccessory : this.catalog){
                stdOut.println(coffeeAccessory.getCode() + "  " + coffeeAccessory.getDescription());
            }
        }
		
	}
	private void displayProduct() throws IOException {
		CoffeeAccessory coffeeAccessory = readProduct();

		stdOut.println("Code: " + coffeeAccessory.getCode());
        stdOut.println("Description: " + coffeeAccessory.getDescription());
        stdOut.println("Price: " + coffeeAccessory.getPrice());

        if (coffeeAccessory instanceof Coffee){
            Coffee coffee = (Coffee) coffeeAccessory;

            stdOut.println("Origin: " + coffee.getOrigin());
            stdOut.println(" Roast: " + coffee.getRoast());
            stdOut.println(" Flavor: " + coffee.getFlavor());
            stdOut.println(" Aroma: " + coffee.getAroma());
            stdOut.println(" Acidity: " + coffee.getAcidity());
            stdOut.println(" Body: " + coffee.getBody());
            stdOut.println(" SmallCharge: " + coffee.getSmallCharge());
        }else if(coffeeAccessory instanceof CoffeeBrewer){
            CoffeeBrewer coffeeBrewer = (CoffeeBrewer) coffeeAccessory;

            stdOut.println(" Model: " + coffeeBrewer.getModel());
            stdOut.println(" Water Supply: " + coffeeBrewer.getWaterSupply());
            stdOut.println(" Capacity: " + coffeeBrewer.getCapacity());
        }
		
	}
	private CoffeeAccessory readProduct() throws IOException {
		do {
            stdErr.print("Product code> ");
            stdErr.flush();

            CoffeeAccessory coffeeAccessory = this.catalog.getProduct(stdIn.readLine());

            if (coffeeAccessory != null){
                return coffeeAccessory;
            }else {
                stdErr.println("There are no products with that code");
            }
        }while (true);
		
	}
	
	private void displayCurrentOrder() {
		int size = this.order.getNumberOfItems();

        if(size == 0){
            stdErr.println("The current order is empty");
        }else {
            for (OrderItem orderItem : this.order){
                stdOut.println(orderItem.toString());
            }
            stdOut.println("Total: " + CURRENCY.format(this.order.getTotalCost()));
        }
		
	}
	private void addProduct() throws IOException {
		CoffeeAccessory coffeeAccessory = readProduct();
        int quantity = readQuantity();
        OrderItem orderItem = this.order.getOrderItem(coffeeAccessory);

        if(orderItem == null){
            this.order.addOrderItem(new OrderItem(coffeeAccessory, quantity));
            stdOut.println("This product " + coffeeAccessory.getCode() + " has been added");
        }else {
            orderItem.setQuantity(quantity);
            stdOut.println("The quantity of the product " + coffeeAccessory.getCode() + " has been modified");
        }
		
	}
	private int readQuantity() throws IOException {
		int quantity;
        do {
            try {
                stdErr.println("Quantity> ");
                stdErr.flush();
                quantity = Integer.parseInt(stdIn.readLine());
                if (quantity > 0){
                    return quantity;
                }else {
                    stdErr.println("Invalid input. Please enter a positive integer");
                }
            }catch (NumberFormatException nfe){
                stdErr.println(nfe);
            }
        }while (true);
	}
	private void removeProdcut() throws IOException {
		CoffeeAccessory coffeeAccessory = readProduct();
        OrderItem orderItem = this.order.getOrderItem(coffeeAccessory);

        if (orderItem != null){
            this.order.removeOrderItem(orderItem);
            stdOut.println("The product " + coffeeAccessory.getCode() + " has been removed from the current order");
        }else {
            stdErr.println("There are no products in the current order with that code");
        }
		
	}
	private void registerCurrentOrder() {
		if (this.order.getNumberOfItems() > 0){
            this.sales.addOrder(this.order);
            stdOut.println("The sale of the order has been registered");
        }else {
            stdErr.println("The current order is empty");
        }
		
	}
	private void displaySals() {
		int numOrder = this.sales.getNumberOfOrders();

        if (numOrder != 0){
            int orderNumber = 1;
            for (Order order : this.sales){
                stdOut.println("Order: " + orderNumber++);

                for (OrderItem orderItem : order){
                    stdOut.println("  " + orderItem.toString());
                }
                stdOut.println(" Total: " + CURRENCY.format(order.getTotalCost()));
            }
        }else {
            stdErr.println("There are no sales");
        }
		
	}
	private void addCatalog() throws IOException {
		do {
			stdErr.println("Please select what type of product you want to add:");
			stdErr.print(     "[a] CoffeeAccessory\n"
                    + "[b] Coffee\n"
                    + "[c] CoffeBrewer\n");
			String typeName;
			typeName = stdIn.readLine();
			if (typeName == "a") {
				CoffeeAccessory newCA = new CoffeeAccessory(stdIn.readLine(),stdIn.readLine(),Double.parseDouble(stdIn.readLine()));
				this.catalog.addProduct(newCA);
			}else if(typeName == "b") {
				Coffee newCoffee = new Coffee(stdIn.readLine(),stdIn.readLine(),Double.parseDouble(stdIn.readLine()),stdIn.readLine(),stdIn.readLine(),stdIn.readLine(),stdIn.readLine(),stdIn.readLine(),stdIn.readLine(),stdIn.readLine());
				this.catalog.addProduct(newCoffee);
			}else if(typeName == "c") {
				CoffeeBrewer newCB = new CoffeeBrewer(stdIn.readLine(),stdIn.readLine(),Double.parseDouble(stdIn.readLine()),stdIn.readLine(),stdIn.readLine(),Integer.parseInt(stdIn.readLine()));
				this.catalog.addProduct(newCB);
			}
		}while(true);
	}
	private void removeCatalog() throws IOException {
		do {
			stdErr.println("Please input the code of the product you want to remove:");
			CoffeeAccessory removeCA = readProduct();
			this.catalog.removeProduct(removeCA);
		}while(true);
	}
	
}

