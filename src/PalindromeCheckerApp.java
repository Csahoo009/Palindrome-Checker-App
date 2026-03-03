import java.util.Scanner;

public class PalindromeCheckerApp{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input : ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);
        System.out.println("Is Palindrome? : " + result);

        scanner.close();
    }

    public static boolean isPalindrome(String text) {
        String normalized = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}