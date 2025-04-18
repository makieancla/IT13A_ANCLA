package MIDTERM;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class RestaurantOrderingSystem {
    static Scanner scanner = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#.00");
    static final String USER_FILE = "users.txt";

    public static void main(String[] args) {
        System.out.println("--- Welcome to the Restaurant Ordering System ---");
        System.out.println("[1] Login");
        System.out.println("[2] Create Account");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        boolean loggedIn = false;
        if (choice == 1) {
            loggedIn = login();
        } else if (choice == 2) {
            createAccount();
            loggedIn = login();
        } else {
            System.out.println("Invalid option.");
            return;
        }

        if (loggedIn) {
            menu();
        }
    }

    // ---------------- CREATE ACCOUNT ----------------

    static void createAccount() {
        System.out.println("\n--- Create New Account ---");
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        String encrypted = encrypt(password);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            writer.write(username + "," + encrypted);
            writer.newLine();
            System.out.println("Account created successfully!");
        } catch (IOException e) {
            System.out.println("Error saving account.");
        }
    }

    // ---------------- LOGIN ----------------

    static boolean login() {
        System.out.println("\n--- Login ---");
        System.out.print("Enter Username: ");
        String inputUser = scanner.nextLine();
        System.out.print("Enter Password: ");
        String inputPass = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(inputUser)) {
                    if (decrypt(parts[1]).equals(inputPass)) {
                        System.out.println("Login successful!");
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading account file.");
            return true;
        }

        System.out.println("Invalid username or password.");
        return false;
    }

    // ---------------- MENU ----------------

    static void menu() {
        String[] items = {"Chicken Adobo", "Pork Adobo", "Halo-halo", "Mango Float", "Vegetable Salad", "Tapioca", "Cake"};
        double[] prices = {120.0, 150.0, 70.0, 100.0, 150.0, 50.0, 250.0};
        int[] quantities = new int[items.length];
        double totalPrice = 0;

        int choice = 0;

        do {
            System.out.println("\n--- Menu ---");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + " - " + items[i] + " (" + df.format(prices[i]) + ")");
            }
            System.out.println("8 - Log Out");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                if (choice == 8) {
                    System.out.println("You have logged out. Thank you for order with us!");
                    break;
                }

                if (choice >= 1 && choice <= 7) {
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();

                    if (qty <= 0) {
                        System.out.println("Invalid quantity! Please enter a positive number.");
                        continue;
                    }

                    int index = choice - 1;
                    quantities[index] += qty;
                    System.out.println("You ordered " + qty + " " + items[index] + "(s).");
                    totalPrice += prices[index] * qty;
                } else {
                    System.out.println("Invalid choice! Please select a valid option.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); 
            }

        } while (true);

        // ---------------- ORDER SUMMARY ----------------
        System.out.println("\n--- Order Summary ---");
        System.out.printf("%-17s %-6s %-8s %-8s\n", "Item", "Qty", "Price", "Subtotal");
        System.out.println("-----------------------------------------");

        boolean hasOrder = false;
        for (int i = 0; i < items.length; i++) {
            if (quantities[i] > 0) {
                hasOrder = true;
                double subtotal = quantities[i] * prices[i];
                System.out.printf("%-17s %-6d %-8s %-8s\n", items[i], quantities[i], df.format(prices[i]), df.format(subtotal));
            }
        }

        if (hasOrder) {
            System.out.println("-----------------------------------------");
            System.out.println(" Total: " + df.format(totalPrice));
        } else {
            System.out.println("No items ordered.");
        }
    }

    // ---------------- ENCRYPTION ----------------

    static String encrypt(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            encrypted.append((char) (c + 3));
        }
        return encrypted.toString();
    }

    static String decrypt(String encrypted) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : encrypted.toCharArray()) {
            decrypted.append((char) (c - 3));
        }
        return decrypted.toString();
    }
}

    
