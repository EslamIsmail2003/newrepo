import java.util.Scanner;

public class Utils {

    public static String getItemInput(){
        Scanner scanner = new Scanner(System.in);
        String itemName=scanner.next();
        return itemName.toLowerCase();
    }
    public static int getNumberInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static long getLongInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }
}