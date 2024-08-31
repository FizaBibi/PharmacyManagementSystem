
import java.util.Scanner;
public class Employee
{
    private int[] id = new int[5];
    private static String[] firstName = new String[5];
    private static String[] lastName = new String[5];
    private short[] age = new short[5];
    private static String[] address = new String[5];
    private static String[] email = new String[5];
    private long[] phoneNumber = new long[5];
    private long[] telephoneNumber = new long[5];
    private static String[] post = new String[5];
    private static float[] salary = new float[5];
    private static String[] degree = new String[5];
    private static String[] university = new String[5];
    private static String[] field = new String[5];

    public void personalInformation() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("\nEmployee #" + (i + 1));
            System.out.print("First name: ");
            firstName[i] = input.nextLine();
            System.out.print("Last name: ");
            lastName[i] = input.nextLine();
            System.out.print("ID: ");
            id[i] = input.nextInt();
            input.nextLine();
            System.out.print("Age: ");
            age[i] = input.nextShort();
            input.nextLine();
            System.out.print("Address: ");
            address[i] = input.nextLine();
        }
        input.close(); // Close the Scanner
    }

    public void contactInformation() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Email: ");
            email[i] = input.nextLine();
            System.out.print("Phone number: ");
            phoneNumber[i] = input.nextLong();
            input.nextLine();
            System.out.print("Telephone number: ");
            telephoneNumber[i] = input.nextLong();
            input.nextLine();
        }
        input.close(); // Close the Scanner
    }

    public static void designation() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Post: ");
            post[i] = input.next();
            System.out.print("Salary: ");
            salary[i] = input.nextFloat();
        }
        input.close(); // Close the Scanner
    }

    public static void education() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Degree: ");
            degree[i] = input.next();
            System.out.print("University: ");
            university[i] = input.next();
            System.out.print("Field of study: ");
            field[i] = input.next();
        }
        input.close(); // Close the Scanner
    }

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter password to login and enter data");
        String password = input.next();

        if (password.equals("islamic123")) {
            personalInformation();
            contactInformation();
            Employee.designation();
            Employee.education();

            // Display the information for each employee
            for (int i = 0; i < 5; i++) {
                System.out.println("\nEmployee #" + (i + 1));
                System.out.println("Personal Information:");
                System.out.println("First Name: " + firstName[i]);
                System.out.println("Last Name: " + lastName[i]);
                System.out.println("ID: " + id[i]);
                System.out.println("Age: " + age[i]);
                System.out.println("Address: " + address[i]);
                System.out.println("Contact Information:");
                System.out.println("Email: " + email[i]);
                System.out.println("Phone No: " + phoneNumber[i]);
                System.out.println("Telephone No: " + telephoneNumber[i]);
                System.out.println("Designation:");
                System.out.println("Post: " + post[i]);
                System.out.println("Salary: " + salary[i]);
                System.out.println("Education:");
                System.out.println("Degree: " + degree[i]);
                System.out.println("University: " + university[i]);
                System.out.println("Field of Study: " + field[i]);
            }
        } else {
            System.out.println("The password you entered is wrong. No access allowed.");
        }
        input.close(); // Close the Scanner
    }

}
