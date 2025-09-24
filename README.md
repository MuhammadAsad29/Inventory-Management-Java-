# Inventory Management (Java)

A simple, console-based Inventory Management system implemented in Java. It demonstrates object-oriented design with classes for `Product`, `Inventory`, `InventoryManager`, and a console-driven `InventoryManagement` application that allows adding, removing, and listing products.

---

## Project Summary

I inspected the project archive and found a single Java source file that contains multiple classes implementing the inventory system. The project uses only core Java (no external libraries) and was developed in an IDE (IntelliJ), which produced compiled `.class` files in the `out/` folder. The project structure (extracted) includes compiled classes and IntelliJ config files, plus the single source file under `src/`.

**Files found (important):**
- `src/InventoryManagement.java` — main Java source containing classes:
  - `Product` — data class for product attributes
  - `Inventory` — stores a list of products and provides add/remove utilities
  - `InventoryManager` — abstract manager interface for inventory operations
  - `StoreInventoryManager` — concrete manager for `Inventory`
  - `InventorySystem` — façade/wrapper that routes requests to an `InventoryManager`
  - `InventoryManagement` — contains the `main` method and console UI

Other files (IDE and compiled output) were present but are not required for running the project from source.

---

## Features
- Add a product to inventory (id, name, quantity, price)
- Remove a product from inventory
- List current inventory items via console menu
- Demonstrates OOP concepts: encapsulation, abstraction (abstract class), and composition

---

## Prerequisites
- Java JDK installed (version 20 or newer recommended)
- A terminal/command prompt (or an IDE like IntelliJ or Eclipse)

---

## How to compile and run (from command line)
1. Open a terminal in the project root directory.
2. Navigate to the `src` directory that contains `InventoryManagement.java`:
```bash
cd src
```
3. Compile the Java source file:
```bash
# Unix / macOS
javac InventoryManagement.java

# Windows (PowerShell or CMD)
javac InventoryManagement.java
```
This will create `*.class` files in the same directory (one per class declared in the file).

4. Run the program:
```bash
# Unix / macOS
java InventoryManagement

# Windows
java InventoryManagement
```
You should see a simple text menu allowing you to add products, remove products (by id), list inventory, or exit.

> Note: If you prefer to run this in IntelliJ IDEA, import the project as a simple Java project (or open the folder), and run the `InventoryManagement` class directly from the IDE.

---

## Code structure & quick reference
- `Product` — stores product ID, name, quantity, and price. Includes basic constructors and `toString()` for listing.
- `Inventory` — internal list of `Product` objects with `addProduct`, `removeProduct`, and helper methods.
- `InventoryManager` — abstract class defining `addProduct` and `removeProduct` methods to be implemented by managers.
- `StoreInventoryManager` — concrete implementation that manipulates the `Inventory` instance.
- `InventorySystem` — a thin wrapper that forwards `addProduct`/`removeProduct` calls to the manager.
- `InventoryManagement.main()` — interactive console UI that reads user input and uses the `InventorySystem` to modify the inventory.

---

## Example usage
1. Run the app.
2. Choose option `1` to add a product — you will be prompted for id, name, price, and quantity.
3. Choose option `2` to remove a product (enter the product id).
4. Choose option `3` to list the current inventory.
5. Choose option `4` to exit.

Example console session:
```
1. Add Product
2. Remove Product
3. Show Inventory
4. Exit
Enter choice: 1
Enter product id: 101
Enter product name: Notebook
Enter product price: 2.5
Enter product quantity: 50
Product added successfully.
```

---

## Possible improvements / next steps
- Move each class into its own `.java` file and use a package (e.g., `com.yourname.inventory`) for cleaner structure.
- Add persistent storage (file-based CSV/JSON or a lightweight database like SQLite/H2) so inventory persists between runs.
- Add input validation and exception handling for robustness (e.g., handle invalid numbers, duplicate IDs).
- Implement search and update product features (update quantity, price).
- Add unit tests (JUnit) to verify core inventory behaviors.
- Create a GUI (Swing/JavaFX) or a small web front-end (Spring Boot) for improved usability.
- Add a `pom.xml` or `build.gradle` to manage builds if converting to a larger project.

---

## License
This project is provided as-is for educational purposes.

---

## Author
Muhammad Asad

---
