import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    Map<String,Product> productMap = new HashMap<>();
    List<Product> inv = new ArrayList<>();

    public void addProduct(Product product){
        inv.add(product);
        productMap.put(product.name.toLowerCase(), product);
    }

    public void addProducts(List<Product> productList){
        inv=productList;
        productMap.clear();
        for(Product product : productList){
            productMap.put(product.name.toLowerCase(), product);
        }
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
