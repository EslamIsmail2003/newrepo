import java.util.HashMap;
import java.util.Scanner;
public class Cart {
    private final HashMap<String, Integer> cart = new HashMap<>();
    public void addItem( Inventory inventory) {
        String item;
        int quan;
        System.out.println("write the product you need to add. ");
        item = Utils.getItemInput();
        if (inventory.getProduct(item) != null){
            System.out.println("How many " + item + " 's do you want");
            quan = Utils.getNumberInput();
            cart.put(item,quan);
        } else{
            System.out.println("Product not found.");
        }
    }
    public HashMap<String, Integer> getCart(){
        return cart;
    }
    public Cart() {
    }
}



