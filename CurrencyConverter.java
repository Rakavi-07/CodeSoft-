import java.util.Scanner;
import java.util.HashMap;

public class CurrencyConverter {

    // Store exchange rates relative to USD
    static HashMap<String, Double> rates = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Sample real-like exchange rates
        rates.put("USD", 1.0);
        rates.put("INR", 83.0);
        rates.put("EUR", 0.92);
        rates.put("GBP", 0.79);
        rates.put("JPY", 156.0);

        System.out.println("===== Currency Converter =====");
        System.out.println("Available Currencies: USD, INR, EUR, GBP, JPY");

        // Base currency
        System.out.print("Enter base currency: ");
        String base = sc.next().toUpperCase();

        // Target currency
        System.out.print("Enter target currency: ");
        String target = sc.next().toUpperCase();

        // Validate currency
        if (!rates.containsKey(base) || !rates.containsKey(target)) {
            System.out.println("❌ Invalid currency selection.");
            return;
        }

        // Amount input
        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("❌ Invalid amount.");
            return;
        }

        // Conversion logic
        double amountInUSD = amount / rates.get(base);
        double convertedAmount = amountInUSD * rates.get(target);

        // Display result with symbol
        System.out.println("\n===== Conversion Result =====");
        System.out.println(amount + " " + base + " = " 
                + String.format("%.2f", convertedAmount) + " " + target);

        sc.close();
    }
}
