import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int choice;
        int choice2;
        System.out.println("*******************************PHARMACY MANAGEMENT SYSTEM************************************************************\n");
        System.out.println("1.Add Pharmacist\n2.Customer Details\n3.Medicines and Suppliers Details\n4.Checkout\n5.Support(FAQs)\n");

        System.out.println("******************************************************************************************************");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice : ");
        choice2 = sc.nextInt();
        Employee e = new Employee();
        while (choice2 != 0) {
            try {                         //NoSuchElementExceptions
                switch (choice2) {
                    case 2: {
                        e.login();
                    }
                case 1: {
                    System.out.println("*********MENU******");
                    System.out.println("Enter 1 to Register or Login\n Enter 2 to store customer Information\n0 to Exit");
                    choice = sc.nextShort();
                    switch (choice) {
                        case 1: {
                            Customer.RegandLogin();
                        }
                        case 2: {
                            Customer.getDetails();
                            Customer.displayDetails();

                        }
                        default: {
                            System.out.println("Invalid Input");
                        }
                        System.exit(0);
                        choice = sc.nextShort();
                    }
                } case 3: {
                    Customer.BuyMedicines();
                } case 4:  {
                    Customer.DoCheckout();
                }  case 5: {
                        Customer.GetHelp();
                    }
                    default: {
                    System.out.println("Invalid Input.");
                }
            }
        }catch (Exception ex) {
                System.out.println("An error occurred: " + ex.getMessage());
            }
            choice2 = sc.nextInt();
        }
        sc.close(); // Closing the Scanner object
    }
}
