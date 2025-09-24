import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InventorySystem {
    private InventoryManager inventoryManager;

    public InventorySystem(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void addProduct(Product product) {
        inventoryManager.addProduct(product);
    }

    public void removeProduct(Product product) {
        inventoryManager.removeProduct(product);
    }
}

class StoreInventoryManager extends InventoryManager {
    private Inventory inventory;

    public StoreInventoryManager(Inventory inventory) {
        this.inventory = inventory;
    }
    public void addProduct(Product product) {
        inventory.addProduct(product);
    }
    public void removeProduct(Product product) {
        inventory.removeProduct(product);
    }
}
abstract class InventoryManager {
    public abstract void addProduct(Product product);
    public abstract void removeProduct(Product product);
}

class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
    public String toString() {
        return "Inventory{" +
                "products=" + products +
                "}";
    }
}
class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                "}";
    }
}

class InventoryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory storeInventory = new Inventory();
        InventoryManager storeManager = new StoreInventoryManager(storeInventory);
        InventorySystem storeSystem = new InventorySystem(storeManager);

        while (true) {
            System.out.println("\nInventory System Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    Product product = new Product(id, name, price, quantity);
                    storeSystem.addProduct(product);
                    System.out.println("Product added: " + product);
                    break;
                case 2:
                    System.out.print("Enter product ID to remove: ");
                    int removeId = scanner.nextInt();
                    Product productToRemove = null;
                    for (Product p : storeInventory.getProducts()) {
                        if (p.getId() == removeId) {
                            productToRemove = p;
                            break;
                        }
                    }
                    if (productToRemove != null) {
                        storeSystem.removeProduct(productToRemove);
                        System.out.println("Product removed: " + productToRemove);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                case 3:
                    System.out.println("Current Inventory: " + storeInventory);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}