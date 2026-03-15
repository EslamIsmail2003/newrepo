import java.util.*;


//TODO write payment class
// payOrder method (( define method signature ))
// order conclusion (( order summary ))
// confirm order and pay
public class Main {
    public static void main(String[] args) {
        Cart shopping = new Cart();
        Inventory controlInv = new Inventory();
        List<Product> productList=defineProducts();
        controlInv.addProducts(productList);
        printIntro();
        processCustomerProducts(controlInv,shopping);
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


    //TODO try to enhance this method
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
                controlInv.productMap.get(item.toLowerCase()).printProductsInfo();
            } else if (choice ==4) {
                System.out.println("Thanks for using our shop! ");
                break;
            }
            else if (choice==5){
                printCart(cart);
            }
            else if (choice==3){
               cart.addItem(controlInv);
            }

        }
    }

    private static void printCart(Cart cart) {
        Map<String, Integer> cartItems=cart.cart;
        System.out.println("cart details : ");
        for (Map.Entry<String ,Integer> entry : cartItems.entrySet()){
            System.out.println("product name : "+entry.getKey()+" with quantity : "+ entry.getValue());
        }
    }

    private static void printOptions(){
        System.out.println("1. View all products.");
        System.out.println("2. Find a product. ");
        System.out.println("3. browse products.");
        System.out.println("4. Exit");
    }

}


