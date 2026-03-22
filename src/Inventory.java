import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    // Making map and list private
    private final Map<String,Product> productMap = new HashMap<>();
    private List<Product> inv = new ArrayList<>();
    // adding getProduct method
    public Product getProduct(String name){
    return productMap.get(name.toLowerCase());
    }

    public void addProduct(Product product){
        inv.add(product);
        productMap.put(product.getName().toLowerCase(), product);
    }

    public void addProducts(List<Product> productList){
        inv=productList;
        productMap.clear();
        for(Product product : productList){
            productMap.put(product.getName().toLowerCase(), product);
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
            total += product.getPrice() * product.getQuantity();
        }
        System.out.println("Total Inventory Value : " + total);
    }

    public void findProduct(String name){
        productMap.get(name.toLowerCase());
    }
}
