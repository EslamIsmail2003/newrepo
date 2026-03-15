import java.util.HashMap;
import java.util.Scanner;
public class Cart {
    HashMap<String, Integer> cart = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    String item;
    int quan;
    public void addItem(String name, int quantity, Inventory inventory) {
        if (inventory.productMap.containsKey(name.toLowerCase())){
            if (cart.containsKey(name.toLowerCase())){
                item = scanner.next();
                System.out.println("How many " + item + " 's do you want");
                quan = scanner.nextInt();
            }
                else{
                System.out.println("Product not found.");
                }
            }
        }


    public Cart() {
    }

    }



