import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        
        Scanner ancla = new Scanner(System.in);

        
        System.out.print("Enter first word: ");
        String makie1 = ancla.nextLine();

      
        System.out.print("Enter second word: ");
        String makie2 = ancla.nextLine();

        
        if (isPalindrome(makie1)) {
            System.out.println(makie1 + " is a palindrome.");
        } else {
            System.out.println(makie1 + " is not a palindrome.");
        }

        if (isPalindrome(makie2)) {
            System.out.println(makie2 + " is a palindrome.");
        } else {
            System.out.println(makie2 + " is not a palindrome.");
        }

     
        ancla.close();
    }

    public static boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false; 
            }
        }
        return true; 
    }
}