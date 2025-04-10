
package prelim;

import java.util.Scanner;
import java.text.DecimalFormat;

public class RestaurantOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int quantity;
        double totalPrice = 0;
        boolean loggedIn = false; 
        String username = "user";  
        String password = "password"; 
        DecimalFormat df = new DecimalFormat("#.00"); 
        

        while (!loggedIn) {
            System.out.println("--- Please Log In ---");
            System.out.print("Enter Username: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Enter Password: ");
            String inputPassword = scanner.nextLine();

           
            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                System.out.println("Login successful!");
                loggedIn = true;
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }
        

        do {
     
            System.out.println("\n--- Welcome to Java Diner ---");
            System.out.println("1 - Burger (₱50)");
            System.out.println("2 - Pasta (₱70)");
            System.out.println("3 - Pizza (₱100)");
            System.out.println("4 - Log Out");
            System.out.print("Enter your choice: ");
            
           
            try {
                choice = scanner.nextInt();

                if (choice == 4) {
                    System.out.println("You have logged out. Thank you for dining with us!");
                    break;
                }

                if (choice >= 1 && choice <= 3) {
                    System.out.print("Enter quantity: ");
                    quantity = scanner.nextInt();
                    
                    
                    if (quantity <= 0) {
                        System.out.println("Invalid quantity! Please enter a positive number.");
                        continue;
                    }

                    switch (choice) {
                        case 1:
                            System.out.println("You ordered " + quantity + " Burger(s)!");
                            totalPrice += 50 * quantity;
                            break;
                        case 2:
                            System.out.println("You ordered " + quantity + " Pasta(s)!");
                            totalPrice += 70 * quantity;
                            break;
                        case 3:
                            System.out.println("You ordered " + quantity + " Pizza(s)!");
                            totalPrice += 100 * quantity;
                            break;
                    }
                } else {
                    System.out.println("Invalid choice! Please select a valid option.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); 
                choice = -1; 
            }

        } while (true); // Loop until the user selects Log Out

        // Display total price if the user ordered anything
        if (totalPrice > 0) {
            System.out.println("Your total bill is: ₱" + df.format(totalPrice));
        }

        scanner.close();
    }
}
    
    
