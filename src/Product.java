public class Product {

    String name;
    double price;
    int quantity;
    int id;
    // TODO use log instead of println

    public Product(String name, double price, int quantity,int id){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id=id;
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
