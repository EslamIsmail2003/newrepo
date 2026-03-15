import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    HashMap<String,Product> productMap = new HashMap<>();
    ArrayList<Product> inv = new ArrayList<>();

    public void addProduct(Product product){
        inv.add(product);
        productMap.put(product.name.toLowerCase(), product);
    }

    public void removeProduct(String name){
        productMap.remove(name.toLowerCase());
    }
    public void printAllProducts(){
        for(Product product : inv){
            product.printProductsInfo();
        }
    }

    public void totalInventoryValue(){
        double total = 0;
        for (Product product : inv){
            total += product.price * product.quantity;
        }
        System.out.println("Total Inventory Value : " + total);
    }

    public void findProduct(String name){
        productMap.get(name);
    }
}
