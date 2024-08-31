import java.util.Scanner;

public class Support {

    Scanner scanner = new Scanner(System.in);
    private static String Reviews;
    private static String FAQ;
    private static String Help;
    public String getReviews() {
        return Reviews;
    }
    public void setReviews(String Reviews) {
        Support.Reviews=Reviews;
    }
    public String getFAQ() {
        return FAQ;
    }
    public void setFAQ(String FAQ)
    {
        Support.FAQ=FAQ;
    }
    public String getHelp()
    {
        return Help;
    }// Add more FAQs as needed
    public void askForHelp() {
        System.out.println("Do you need help with anything else? Enter 'yes' or 'no':");
        String help = scanner.nextLine();
        if (help.equals("yes")) {
            System.out.println("Please enter your specific concern:");
            String question = scanner.nextLine();
            System.out.println("Thank you for your concern: " + question);
            System.out.println("We will soon get back to you");
            askForHelp(); // Continue asking for help
        } else {
            System.out.println("Thank you for using our pharmacy management system.");
            System.exit(0); // Exit the program
        }
    }

    public void setHelp(String Help)
    {
        Support.Help=Help;
    }
    public void askForReview() {
        System.out.println("Thank you for using our pharmacy management system.");
        String review;
        do {
            System.out.println("Please leave a review to help us improve:");
            review = scanner.nextLine();
            System.out.println("Thank you for your review: " + review);
            System.out.println("Do you want to write another review? Enter 'yes' to continue or 'no' to exit: ");
            String userInput = scanner.nextLine();
            if (userInput.equals("no")) {
                System.out.println("Thank you for your feedback.");
                System.exit(0);
            }
        } while (true);
    }


    public void displayFAQ() {
        System.out.println("Frequently Asked Questions:");
        System.out.println("Q: How do I add a new medicine to the system?");
        System.out.println("A: Please navigate to the 'Medicines' tab and click on 'Add Medicine'.");
        System.out.println("Q: How do I view the inventory of a specific medicine?");
        System.out.println("A: Please navigate to the 'Medicines' tab and click on the medicine name to view its inventory.");

        System.out.println("Do you want to continue? Enter 'yes' to continue or 'no' to exit: ");
        String userInp = scanner.nextLine();
        if (userInp.equals("no")) {
            System.out.println("Thank you for using our pharmacy management system.");
            System.exit(0);
        }
    }
}
