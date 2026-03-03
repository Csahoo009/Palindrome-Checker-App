import java.util.Scanner;
import java.util.Stack;

interface PalindromeStrategy {
    boolean check(String input);
}

class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCheck(String input) {
        return strategy.check(input);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.print("Input : ");
        String input = scanner.nextLine();

        context.setStrategy(new StackStrategy());
        System.out.println("Is Palindrome? : " + context.executeCheck(input));

        scanner.close();
    }
}