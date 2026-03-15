public class Product {

    String name;
    double price;
    int quantity;


    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void printProductsInfo(){
        System.out.println("Name: " + name + ", Price: " + price + ", Quantity: " + quantity );
    }
    public void totalProductsValue(){
        System.out.println("Total Value: " + (price * quantity));
    }
    public void restockProducts(int amount){
        quantity += amount;
    }
}
