import java.util.Map;

public class Payment {
    private final Cart cart;
    private final Inventory inventory;
    public Payment(Cart cart, Inventory inventory){
        this.cart = cart;
        this.inventory = inventory;
    }
    public void showOrderSummary(){
        double total = 0;
        for(Map.Entry<String, Integer> entry : cart.getCart().entrySet()){
        String productName = entry.getKey();
        int quantity = entry.getValue();
        Product product = inventory.getProduct(productName);
        double price = product.getPrice();
        total += price * quantity;
            System.out.println(productName + " x" + quantity + " = " + String.format("%.2f", price * quantity) + " $");
        }
        System.out.println("Your total order summary is " + String.format("%.2f", total) + " $");
    }
    public void confirmOrder(){
    System.out.println("Do you want to confirm this order? (Yes/No) ");
    String input = Utils.getItemInput();
    if (input.equals("yes")){
        processPayment();
    }
    else if(input.equals("no")){
        System.out.println("Order Cancelled! ");
    }
    }

    public void processPayment(){
        System.out.println("Please enter your card number: ");
        long card = Utils.getLongInput();
        while (String.valueOf(card).length() != 16){
            System.out.println("Invalid cart number! Please enter a 16 digit card number: ");
            card = Utils.getLongInput();
        }
        System.out.println("Payment Successful! ");
        System.out.println("Thanks for using our shop! ");
    }
}
