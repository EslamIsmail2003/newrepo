import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cart shopping = new Cart();
        Inventory controlInv = new Inventory();
        Scanner scanner = new Scanner(System.in);
        int choice;
        String item;


        Product p1 = new Product("Laptop", 999.99, 5);
        Product p2 = new Product("Phone", 499.99, 10);
        Product p3 = new Product("Tablet", 299.99, 7);
        Product p4 = new Product("Tv", 699.99, 12);
        Product p5 = new Product("Headset", 199.99, 20);

        controlInv.addProduct(p1);
        controlInv.addProduct(p2);
        controlInv.addProduct(p3);
        controlInv.addProduct(p4);
        controlInv.addProduct(p5);

        System.out.println("Welcome to the store!");
        System.out.println("Please select from following : ");

        while (true) {

            System.out.println("1. View all products.");
            System.out.println("2. Find a product. ");
            System.out.println("3. Exit");

            choice = scanner.nextInt();

            if (choice == 1) {
                controlInv.printAllProducts();
            }

            else if (choice == 2) {
                System.out.println("Please enter the product name: ");
                item = scanner.next();
                controlInv.productMap.get(item).printProductsInfo();
            } else if (choice == 3) {
                System.out.println("Thanks for using our shop! ");
            }
        }
    }
}


