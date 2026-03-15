import java.util.HashMap;
import java.util.Scanner;
public class Cart {
    public HashMap<String, Integer> cart = new HashMap<>();
    String item;
    int quan;
    public void addItem( Inventory inventory) {
        System.out.println("write the product you need to add. ");
        item = Utils.getItemInput(); // get item name from the user
        if (inventory.productMap.containsKey(item)){
            System.out.println("How many " + item + " 's do you want");
            quan = Utils.getNumberInput();
            cart.put(item,quan);
        } else{
            System.out.println("Product not found.");
        }
    }

    public Cart() {
    }

    }



