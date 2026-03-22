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
            cart.put(item.toLowerCase(),quan);
        } else{
            System.out.println("Sorry, We don't have this product. ");
        }
    }
    public void removeItem(String name) {
        String key = name.toLowerCase();
        if (cart.containsKey(key)) {
            cart.remove(key);
        } else {
            System.out.println("Product not found in cart.");
        }
    }
    public void removeQuantity(String name, int quan){
        String key = name.toLowerCase();
        if (cart.containsKey(key)){
            int currentQuantity = cart.get(key);
            if (quan>= currentQuantity){
                cart.remove(key);
                System.out.println("Items removed from the cart! ");
            }
            else {
                cart.put(key,currentQuantity- quan);
                System.out.println("Quantity updated successfully! ");
            }
        }
    }
    public HashMap<String, Integer> getCart(){
        return cart;
    }
    public Cart() {
    }
}



