package Aufgabe2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Repository<Produkte> productRepository = new Repository<Produkte>();
        Repository<Charaktere> clientRepository = new Repository<Charaktere>();
        Controller controller = new Controller(productRepository, clientRepository);
        controller.createProduct(700.00, "Snowboard", "Winter");
        controller.createProduct(200.00, "Rollerskates", "Spring");
        controller.createProduct(59.00, "Swimsuit", "Summer");
        List<Integer> prods = new ArrayList<>();
        prods.add(1);
        prods.add(2);
        controller.createChar("Bob", "Bucharest", prods);
        System.out.println(controller.filterByHerkunft("Bucharest"));
        System.out.println(controller.filterByProd(1));
        System.out.println(controller.sortCharProds(1, "ascending"));
        System.out.println(controller.sortCharProds(1, "descending"));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an operation:");
            System.out.println("1. Create Product");
            System.out.println("2. Create Charakter");
            System.out.println("3. Read Product");
            System.out.println("4. Read Charaakter");
            System.out.println("5. Update Product");
            System.out.println("6. Update Charakter");
            System.out.println("7. Delete Product");
            System.out.println("8. Delete Charakter");
            System.out.println("9. Filter Charakter by origin");
            System.out.println("10. Sort Charakter Products by Price");
            System.out.println("11. Filter Charakter by Product bought");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Create a Product
                    System.out.print("Enter Product Name: ");
                    String prodName = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter origin: ");
                    String origin = scanner.nextLine();
                    controller.createProduct(price, prodName, origin);
                    System.out.println("Product created successfully!");
                    break;
                case 2:
                    // Create a Client
                    System.out.print("Enter Charakter Name: ");
                    String charName = scanner.nextLine();
                    System.out.print("Enter Charakter origin: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter number of Products to link: ");
                    int prodCount = scanner.nextInt();
                    List<Integer> prodIds = new ArrayList<>();
                    for (int i = 0; i < prodCount; i++) {
                        System.out.print("Enter Product ID to link: ");
                        prodIds.add(scanner.nextInt());
                    }
                    controller.createChar(charName, location, prodIds);
                    System.out.println("Charakter created successfully!");
                    break;
                case 3:
                    // Read a Product
                    System.out.print("Enter Product ID to read: ");
                    int prodId = scanner.nextInt();
                    Produkte product = controller.readProduct(prodId);
                    System.out.println("Product: " + product);
                    break;
                case 4:
                    // Read a Client
                    System.out.print("Enter Client ID to read: ");
                    int charId
                            = scanner.nextInt();
                    Charaktere charak = controller.updateChar(charId);
                    System.out.println("Client: " + charak);
                    break;
                case 5:
                    // Update a Product
                    System.out.print("Enter Product ID to update: ");
                    prodId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Produkte prodToUpdate = controller.readProduct(prodId);
                    System.out.print("Enter new Product Name: ");
                    prodToUpdate.setName(scanner.nextLine());
                    System.out.print("Enter new Product Price: ");
                    prodToUpdate.setPreis(scanner.nextDouble());
                    scanner.nextLine();  // Consume newline
                    controller.updateProduct(prodToUpdate);
                    System.out.println("Product updated successfully!");
                    break;
                case 6:
                    // Update a Client
                    System.out.print("Enter Charakter ID to update: ");
                    charId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Charaktere charToUpdate = controller.updateChar(charId);
                    System.out.print("Enter new Charakter Name: ");
                    charToUpdate.setName(scanner.nextLine());
                    System.out.print("Enter new Charakter Location: ");
                    charToUpdate.setHerkunftsort(scanner.nextLine());
                    controller.updateChar(charToUpdate);
                    System.out.println("Charakter updated successfully!");
                    break;
                case 7:
                    // Delete a Product
                    System.out.print("Enter Product ID to delete: ");
                    prodId = scanner.nextInt();
                    controller.deleteProduct(prodId);
                    System.out.println("Product deleted successfully!");
                    break;
                case 8:
                    // Delete a Client
                    System.out.print("Enter Client ID to delete: ");
                    charId = scanner.nextInt();
                    controller.deleteChar(charId);
                    System.out.println("Client deleted successfully!");
                    break;
                case 9:
                    // Filter Clients by Location
                    System.out.print("Enter origin to filter by: ");
                    String locationFilter = scanner.nextLine();
                    List<Charaktere> charsByLoc = controller.filterByHerkunft(locationFilter);
                    System.out.println("Clients at " + locationFilter + ": " + charsByLoc);
                    break;
                case 10:
                    System.out.print("Enter Char ID to sort products: ");
                    charId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Sort order (ascending/descending): ");
                    String order = scanner.nextLine();
                    List<Produkte> sortedProds = controller.sortCharProds(charId, order);
                    System.out.println("Sorted Products: " + sortedProds);
                    break;
                case 11:
                    // Show Clients that Bought Products for a Specific Season
                    System.out.print("Enter ProdId: ");
                    int searchedProdId = scanner.nextInt();
                    List<Charaktere> charByProd = controller.filterByProd(searchedProdId);
                    System.out.println("Clients who bought product " + searchedProdId + ": " + charByProd);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }

        scanner.close();
    }
}
