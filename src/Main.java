import java.util.*;

//TODO write payment class / done
// payOrder method (( define method signature )) / done
// order conclusion (( order summary )) / done
// confirm order and pay / done
public class Main {
    public static void main(String[] args) {
        Cart shopping = new Cart();
        Inventory controlInv = null;
        controlInv = new Inventory();
        List<Product> productList = defineProducts();
        controlInv.addProducts(productList);
        printIntro();
        processCustomerProducts(controlInv, shopping);
    }

    private static List<Product> defineProducts() {
        Product p1 = new Product("Laptop", 999.99, 5,1);
        Product p2 = new Product("Phone", 499.99, 10,2);
        Product p3 = new Product("Tablet", 299.99, 7,3);
        Product p4 = new Product("Tv", 699.99, 12,4);
        Product p5 = new Product("Headset", 199.99, 20,5);
        return List.of(p1,p2,p3,p4,p5);
    }

    private static void printIntro(){
        System.out.println("Welcome to the store!");
        System.out.println("Please select from following : ");
    }

    //TODO try to enhance this method / done
    private static void processCustomerProducts(Inventory controlInv,Cart cart){
        int choice ;
        String item;
        while (true) {
            printOptions();
            choice = Utils.getNumberInput();
            if (choice == 1) {
                controlInv.printAllProducts();
            }
            else if (choice == 2) {
                System.out.println("Please enter the product name: ");
                item = Utils.getItemInput();
                Product found = controlInv.getProduct(item); //fixed find item method
                if (found != null) {
                    found.printProductsInfo();
                } else {
                    System.out.println("Sorry we don't have this product");
                }
            }
             else if (choice==3){
                cart.addItem(controlInv);
            }
            else if (choice ==4) {
                printCart(cart, controlInv);
            }
            else if (choice==5){
                Payment payment = new Payment(cart, controlInv);
                payment.showOrderSummary();
            }
            else if (choice == 6){
                Payment payment = new Payment(cart, controlInv);
                payment.confirmOrder();
            }
            else if(choice == 7){
                System.out.println("Thanks for using our shop! ");
                break;
            }
        }
    }
    private static void printCart(Cart cart, Inventory inventory) {
        Map<String, Integer> cartItems = cart.getCart();
        System.out.println("Cart details : ");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            Product product = inventory.getProduct(productName);
            double price = product.getPrice();
            System.out.println("Product name : " + productName + " , Product price : " + String.format("%.2f", price) + " , Quantity : " + quantity);
        }
    }
    private static void printOptions(){
        System.out.println("1. View all products.");
        System.out.println("2. Find a product.");
        System.out.println("3. browse products.");
        System.out.println("4. View cart.");
        System.out.println("5. Order summary.");
        System.out.println("6. Confirm order. ");
        System.out.println("7. Exit");
    }
}


