import java.util.Stack;

public class MirrorBreakerOptimal {

    public static boolean geminiWins(String s) {
        Stack<Character> stack = new Stack<>();
        int moves = 0;

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();  // remove pair
                moves++;
            } else {
                stack.push(c);
            }
        }

        return moves % 2 == 1; // odd moves -> first wins
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(geminiWins(s) ? "Yes" : "No");
    }
}