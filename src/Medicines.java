
import java.util.Scanner;
public class Medicines {
    private static String[] name = {"Xanax", "Nexium", "Zocor", "Aspirin", "bupro", "Naprox", "Penicil", "Zyrtec", "Astelin", "Rhinoc", "Singul", "Antacid", "thyrox", "risper", "warfin", "furose", "Nexium", "Propran", "Amox"};
    private static String[] manufacturer = {"Merck & co ", "Pfizer", "AstraZeneca", "GlaxoSmithKline", "AbbVie", "Sanofi", "Novartis", "Abbott", "Bristol Myers Squibb", "Roche"};
    private static String[] type = {"BZD", "PPI", "STATINS", "NSAID", "NSAID", "NSAID", "BETALA", "ANTIHIS", "ANTIHIS", "CORTICO", "RECEPT", "TITRA", "THYROX", "ATP", "ANTICO", "DIURET", "PROTON", "BETA", "PENICIL"};
    private static double[] price = {23.87, 238.50, 226.55, 50.00, 14, 96.5, 740.00, 104.39, 70, 104, 110, 100, 120, 175, 18.4, 45.0, 61.00, 1.88, 132};
    private static int[] quantity = {20, 15, 13, 24, 30, 35, 50, 40, 28, 25, 10, 28, 50, 55, 100, 150, 160, 80, 70};
    private static String[] presc = {"Xanax", "Zocor", "Nexium", "Naprox"};
    private static String[] category = {"Antidepressant", "GERD", "HDL", "Pain-Relief", "Pain-Relief", "Analgesic", "AntiBacterial", "Allergies", "Allergy", "Intranasal", "Allergic", "Acidity", "Thyroid", "Sedative", "Blood Thinner", "Edema", "GERD", "Beta Blocker", "Antibiotic"};

    // Getters and Setters
    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        Medicines.name = name;
    }

    public String[] getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String[] manufacturer) {
        Medicines.manufacturer = manufacturer;
    }
    public String[] gettype()
    {
        return type;
    }
    public void settype(String[] type)
    {
        Medicines.type=type;
    }public double[] getPrice() {
        return price;
    }

    public void setPrice(double[] price) {
        Medicines.price = price;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        Medicines.quantity = quantity;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        Medicines.category = category;
    }
    public String[] isPrescriptionRequired() {
        return presc;
    }

    public void setPrescriptionRequired(String[] presc) {
        Medicines.presc = presc;
    }

    public static void Submenu() {
        boolean loop=true;
        while(loop==true) {
            int c;
            System.out.println("1. List Existing Suppliers.");
            System.out.println("2. Search Medicine");
            System.out.println("3. Stock Medicine");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter choice: ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    DispSuppList();
                    break;
                case 2:
                    SearchMed();
                    break;
                case 3:
                    Stock();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("Do you want to continue? Enter 1 to cont, 0 to exit");
            int choice=sc.nextInt();
            if(choice==1)
                loop=true;
            else
                loop=false;
        }
    }


    public static void DispSuppList() {
        for (int i = 0; i < manufacturer.length; i++) {
            System.out.println("Supplier ID: " + (i + 1));
            System.out.println("Supplier Name: " + manufacturer[i]);
            System.out.println("-----------------------");
        }
    }

    public static void Stock() {
        System.out.println("********************************************************************************************");
        System.out.println("MED ID\t\t TYPE\t\t NAME\t\t Price\t    QUANTITY\t\tCATEGORY");
        System.out.println("********************************************************************************************");
        for (int i = 0; i < name.length; i++) {
            System.out.println((i + 1) + "\t\t" + type[i] + "\t\t" + name[i] + "\t\t" + price[i] + "\t\t" + quantity[i] + "\t\t" + category[i]);
        }
    }

    public static void SearchMed() {
        int i = 0;
        int found = -1;
        String str = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Medicine Name: ");
        str = sc.nextLine();
        while (str.isEmpty()) {
            System.out.print("Please enter a valid medicine name: ");
            str = sc.nextLine();
        }
        for (i = 0; i < name.length; i++) {
            if (str.compareTo(name[i]) == 0) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            System.out.println(str + " not found");
        } else {
            System.out.println("Search Successful");
            System.out.println("Name: " + name[found] + " found.");
            System.out.print("Do you want to know if a prescription is required for " + name[found] + "? (yes/no): ");
            String userInput = sc.nextLine();
            while (!(userInput.equals("yes") || userInput.equals("no"))) {
                System.out.print("Please enter a valid response (yes/no): ");
                userInput = sc.nextLine();
            }
            if (userInput.equals("yes")) {
                boolean prescriptionRequired = false;
                for (i = 0; i < presc.length; i++) {
                    if (name[found].equals(presc[i])) {
                        prescriptionRequired = true;
                        break;
                    }
                }
                if (prescriptionRequired) {
                    System.out.println("Name: " + name[found] + " requires a prescription.");
                } else {
                    System.out.println("Name: " + name[found] + " does not require a prescription.");
                }
            }
        }
    }


    public static void main(String[] args) {
        Submenu();
    }
}
