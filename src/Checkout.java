import java.util.Scanner;

public class Checkout {
    private static Scanner sc = new Scanner(System.in); // Make sc static
    private static String[] products = new String[2];
    private static short[] prices = new short[2];
    private static int[] quantities = new int[2];
    private static String[] shippingDetails = new String[5];
    private static float[] discountRates = new float[2];
    private static String paymentMode;
    private static double amount;
    private static char mode;
    private static String cardNumber;
    private static String cardType;
    private static String expiryDate;

    public String[] getProducts() {
        return products;
    }

    public void setProducts(String[] products) {
        Checkout.products = products;
    }

    public short[] getPrices() {
        return prices;
    }

    public void setPrices(short[] prices) {
        Checkout.prices = prices;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public void setQuantities(int[] quantities) {
        Checkout.quantities = quantities;
    }

    public String[] getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(String[] shippingDetails) {
        Checkout.shippingDetails = shippingDetails;
    }

    public float[] getDiscountRates() {
        return discountRates;
    }

    public void setDiscountRates(float[] discountRates) {
        Checkout.discountRates = discountRates;
    }

    public static String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        Checkout.paymentMode = paymentMode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public char getMode() {
        return mode;
    }

    public void setMode(char mode) {
        Checkout.mode = mode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public static void setProductDetails() {
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter product name: ");
            products[i] = sc.nextLine();
            System.out.print("Enter price: ");
            prices[i] = sc.nextShort();
            System.out.print("Enter quantity: ");
            quantities[i] = sc.nextInt();
            sc.nextLine(); // clear input buffer
            System.out.print("Is there a discount on " + products[i] + "? (y/n) ");
            char choice = sc.nextLine().charAt(0);
            if (choice == 'y') {
                System.out.print("Enter discount rate: ");
                discountRates[i] = sc.nextFloat();
            } else {
                System.out.println("Sorry, no discount rate.");
                discountRates[i] = 0;
            }

            if (i < 1) {
                System.out.print("Do you want to enter details for another product? (yes/no): ");
                String userInput = sc.nextLine();
                if (!userInput.equalsIgnoreCase("yes")) {
                    break; // exit the loop if the user doesn't want to enter details for another product
                }
            }
        }
    }

    public static void applyDiscount() {
        for (int i = 0; i < 2; i++) {
            if (discountRates[i] > 0) {
                prices[i] = (short) (prices[i] * quantities[i] * (1 - discountRates[i] / 100));
                System.out.println("Total Price after discount of " + products[i] + " is Rs " + prices[i]);
            } else {
                prices[i] = (short) (prices[i] * quantities[i]);
            }
        }
    }

    public static void setShippingDetails() {
        sc.nextLine(); // clear input buffer
        System.out.print("Enter Recipient name: ");
        shippingDetails[0] = sc.nextLine();
        System.out.print("Enter email address: ");
        shippingDetails[1] = sc.nextLine();
        System.out.print("Enter phone number: ");
        shippingDetails[2] = sc.nextLine();
        System.out.print("Enter address: ");
        shippingDetails[3] = sc.nextLine();
        System.out.print("Enter shopping date (YYYY-MM-DD): ");
        shippingDetails[4] = sc.nextLine();
    }

    public static void getPaymentModee() {
        System.out.print("Enter the payment mode (1 for cash/2 for card): ");
        mode = sc.next().charAt(0);
        if (mode == '1') {
            System.out.println("Order has been placed.");
        } else if (mode == '2') {
            System.out.print("Enter the card type: ");
            cardType = sc.next();
            System.out.print("Enter the card number: ");
            cardNumber = sc.next();
            System.out.print("Enter the expiry date: ");
            expiryDate = sc.next();
        } else {
            System.out.println("Invalid payment mode.");
        }
    }

    public static void display() {
        System.out.println("Item \tPrice \tQuantity \tDiscount");
        for (int i = 0; i < 2; i++) {
            System.out.println(products[i] + "\t" + prices[i] + "\t" + quantities[i] + "\t" + prices[i]);
            System.out.println();
        }
        int totalAmount = 0;
        for (int i = 0; i < 2; i++) {
            totalAmount += prices[i];
        }
        System.out.println("\nTotal amount: Rs" + totalAmount);
        System.out.println("\nSelect payment mode");
        Checkout.getPaymentModee();
        if (mode == '1') {
            System.out.println("Payment Mode: Cash");
        } else if (mode == '2') {
            System.out.println("Payment Mode: Credit Card");
            System.out.println("Card Type: " + cardType);
            System.out.println("Card Number: " + cardNumber);
            System.out.println("Expiry Date: " + expiryDate);
            System.out.println();
            System.out.println("Shipping Details:");
            System.out.println("Name: " + shippingDetails[0]);
            System.out.println("Email Address: " + shippingDetails[1]);
            System.out.println("Phone Number: " + shippingDetails[2]);
            System.out.println("Address: " + shippingDetails[3]);
            System.out.println("Shopping Date: " + shippingDetails[4]);
            System.out.println();
            System.out.println("Credit card payment of Rs." + totalAmount + " has been made using the card.");
        }
        System.out.println("\n---------------- Thank You for Shopping! -----------------");
        System.out.println("Visit Again");
    }

    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        Checkout.setProductDetails();
        Checkout.applyDiscount();
        Checkout.setShippingDetails();
        Checkout.getPaymentModee(); // Fixed method name
        Checkout.display();
    }
}
