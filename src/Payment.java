import java.util.Map;

public class Payment {
    private final Cart cart;
    private final Inventory inventory;

    public Payment(Cart cart, Inventory inventory) {
        this.cart = cart;
        this.inventory = inventory;
    }

    public void showOrderSummary() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.getCart().entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            Product product = inventory.getProduct(productName);
            double price = product.getPrice();
            total += price * quantity;
            System.out.println(productName + " x" + quantity + " = " + String.format("%.2f", price * quantity) + " $");
        }
        System.out.println("Your total order summary is " + String.format("%.2f", total) + " $");
        //adding discount method to verify if total exceeds certain amount gets discount of x% verifying by discount code
        //if users enters wrong code it gives discount code not found please retry

    }

    public void confirmOrder() {
        System.out.println("Do you want to confirm this order? (Yes/No) ");
        String input = Utils.getItemInput();
        if (input.equals("yes")) {
            processPayment();
        } else if (input.equals("no")) {
            System.out.println("Order Cancelled! ");
        }
    }

    public void paymentMethod(){
        String input;
        System.out.println("How would you like to pay? (COD/Card)");
        input = Utils.getItemInput();
        if (input.equalsIgnoreCase("COD")){
            System.out.println("Thanks for using our shop! ");
        }
        else if(input.equalsIgnoreCase("Card")){
            processPayment();
        }
    }

    public void processPayment() {
        System.out.println("Please enter your card number: ");
        long card = Utils.getLongInput();
        if (String.valueOf(card).length() == 16) {
            System.out.println("Payment confirmed! ");
            System.out.println("Thank you for using our shop! ");
        } else {
            while (String.valueOf(card).length() != 16) {
                System.out.println("Invalid number! Please enter your 16 digit card number: ");
                card = Utils.getLongInput();
                if (String.valueOf(card).length() == 16) {
                    System.out.println("Payment confirmed! ");
                    System.out.println("Thank you for using our shop! ");
                }

            }
        }
    }
}