
import java.util.Scanner;
public class Customer
{
    static Support sp = new Support();
    static Checkout ch=new Checkout();
    static Medicines m = new Medicines();
    static Scanner sc = new Scanner(System.in);
    private static String[] name = new String[5];
    private static String[] address = new String[5];
    private static int[] phoneNumber = new int[5];
    private static String[] email = new String[5];
    private static short[] age = new short[5];
    private static String[] gender = new String[5];
    private static String[] UserName_Register = new String[5];
    private static String[] Password_Register = new String[5];
    private static String[] UserName_Login = new String[5];
    private static String[] Password_Login = new String[5];

    public static String[] getName() {
        return name;
    }

    public static void setName(String[] name) {
        Customer.name = name;
    }

    public static String[] getEmail() {
        return email;
    }

    public static void setEmail(String[] email) {
        Customer.email = email;
    }

    public static short[] getAge() {
        return age;
    }

    public static void setAge(short[] age) {
        Customer.age = age;
    }

    public static String[] getAddress() {
        return address;
    }

    public static void setAddress(String[] address) {
        Customer.address = address;
    }

    public static int[] getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(int[] phoneNumber) {
        Customer.phoneNumber = phoneNumber;
    }

    public static String[] getGender() {
        return gender;
    }

    public static void setGender(String[] gender) {
        Customer.gender = gender;
    }

    public static String[] getUserName_Register() {
        return UserName_Register;
    }

    public static void setUserName_Register(String[] userName_Register) {
        UserName_Register = userName_Register;
    }

    public static String[] getPassword_Register() {
        return Password_Register;
    }

    public static void setPassword_Register(String[] password_Register) {
        Password_Register = password_Register;
    }

    public static String[] getUserName_Login() {
        return UserName_Login;
    }

    public static void setUserName_Login(String[] userName_Login) {
        UserName_Login = userName_Login;
    }

    public static String[] getPassword_Login() {
        return Password_Login;
    }

    public static void setPassword_Login(String[] password_Login) {
        Password_Login = password_Login;
    }

    public static void RegandLogin() {
        Scanner sc = new Scanner(System.in);
        String[] UserName_Register = new String[5];
        String[] Password_Register = new String[5];

        // Register up to 5 users
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Username: ");
            String username = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                if (UserName_Register[j] != null && UserName_Register[j].equals(username)) {
                    System.out.println("Username already taken.");
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                UserName_Register[i] = username;
                Password_Register[i] = password;
                System.out.println("You registered successfully.");
            }
        }

        // Prompt for login or exit
        while (true) {
            System.out.print("Enter 'login' to login or 'exit' to exit: ");
            String input = sc.nextLine();
            if (input.equals("login")) {
                System.out.print("Enter Username: ");
                String username = sc.nextLine();
                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                boolean found = false;
                for (int i = 0; i < 5; i++) {
                    if (UserName_Register[i] != null && UserName_Register[i].equals(username)) {
                        found = true;
                        if (Password_Register[i].equals(password)) {
                            System.out.println("You Logged-in Successfully.");
                        } else {
                            System.out.println("Your Password is incorrect. Please try again with the correct Password.");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Your Username is incorrect. Please try again with the correct Username.");
                }
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        sc.close();
    }


    public static void BuyMedicines() {
        Medicines.Submenu();
    }

    public static void GetHelp() {
        int choice;
        System.out.println("Enter 1 to give a review about our Service.");
        System.out.println("Enter 2 to display FAQs.");
        System.out.println("Enter 3 for Further Help.");
        System.out.println("Enter 0 to Exit.");
        choice = sc.nextInt();
        boolean exit = false;
        while (!exit) {
            if (choice == 1) {
                sp.askForReview();
            } else if (choice == 2) {
                sp.displayFAQ();
            } else if (choice == 3) {
                sp.askForHelp();
            } else if (choice == 0) {
                System.out.println("Exit");
                exit = true;
            } else {
                System.out.println("Invalid Input. Enter input according to the provided menu.");
            }
        }
    }

    public static void DoCheckout()
    {

        Checkout.setProductDetails();
        Checkout.applyDiscount();
        Checkout.setShippingDetails();
        Checkout.getPaymentMode();
        Checkout.display();
    }

    public static void getDetails()
    {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<10;i++)
        {
            System.out.print("Enter customer name: ");
            name[i] = sc.nextLine();
            System.out.print("Enter customer gender: ");
            gender[i]=sc.nextLine();
            System.out.print("Enter customer address: ");
            address[i] = sc.nextLine();
            System.out.print("Enter customer phone number: ");
            phoneNumber[i] = sc.nextInt();
            System.out.print("Enter customer email: ");
            email[i]=sc.next();
            System.out.print("Enter customer age: ");
            age[i] = sc.nextShort();
        }
    }

    public static void displayDetails()
    {
        System.out.println("\t\t\t\t--------------------Customer Details-----------------");
        for(int i=0;i<10;i++)
        {
            System.out.println("Name: " + name[i]);
            System.out.println("Address: " + address[i]);
            System.out.println("Phone number: " + phoneNumber[i]);
            System.out.println("Email: " + email[i]);
            System.out.println("Age: " + age[i]);
            System.out.println("Gender: " + gender[i]);
        }
    }
}
