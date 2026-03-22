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
             else if (choice==2) {
                while (true) {
                    String input;
                    cart.addItem(controlInv);
                    System.out.println("Would you like to order anything else ? (Yes/No): ");
                    input = Utils.getItemInput();
                    if (input.equals("yes")) {
                        continue;
                    }
                    else if (input.equals("no")){
                        System.out.println("Added items to cart! ");
                    }
                    break;
                }
            }
            else if (choice == 3) {
                while (true) {
                    String input;
                    String input2;
                    printCart(cart, controlInv);
                    System.out.println("..........");
                    System.out.println("Would you like to remove any items from the cart? (Yes/No): ");
                    input = Utils.getItemInput();
                    if (input.equalsIgnoreCase("yes")) {
                        System.out.println("Which product would you like to remove: ");
                        input2 = Utils.getItemInput();
                        System.out.println("How many would you like to remove? (enter 0 to remove all): ");
                        int quan = Utils.getNumberInput();
                        if (quan == 0) {
                            cart.removeItem(input2);
                        } else {
                            cart.removeQuantity(input2, quan);
                        }
                    } else if (input.equalsIgnoreCase("no")) {
                        break;
                    }
                }
            }
            else if (choice==4){
                Payment payment = new Payment(cart, controlInv);
                payment.showOrderSummary();
            }
            else if (choice == 5){
                Payment payment = new Payment(cart, controlInv);
                payment.paymentMethod();
            }
            else if(choice == 6){
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
            System.out.println("Product name : " + Character.toUpperCase(productName.charAt(0)) + productName.substring(1)+ " , Price each : " + String.format("%.2f", price) + " , Quantity ordered : " + quantity);
        }
    }
    private static void printOptions(){
        System.out.println("1. View all products.");
        System.out.println("2. Add items to cart.");
        System.out.println("3. View cart.");
        System.out.println("4. Order summary.");
        System.out.println("5. Confirm order. ");
        System.out.println("6. Exit");
    }
}


// adding items method should always loop until user decided to move to check out. // done
//  System.out.println("4. Remove items from the cart. ");  >>> add remove items from cart if user doesn't want it // done
//Add COD or Card payment to options/ done


