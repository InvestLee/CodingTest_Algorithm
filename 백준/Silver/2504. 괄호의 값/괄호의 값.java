import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bracket = br.readLine();
        Stack<Character> bracketStack = new Stack<>();
        int result = 0;
        int term = 1;
        for (int i = 0; i < bracket.length(); i++){
            if (bracket.charAt(i) == '('){
                bracketStack.push(bracket.charAt(i));
                term *= 2;
            }
            else if (bracket.charAt(i) == '['){
                bracketStack.push(bracket.charAt(i));
                term *= 3;
            }
            else if (bracket.charAt(i) == ')'){
                if (bracketStack.isEmpty() || bracketStack.peek() != '('){
                    result = 0;
                    break;
                }
                if (bracket.charAt(i-1) == '(') result += term;
                bracketStack.pop();
                term /= 2;
            }
            else {
                if (bracketStack.isEmpty() || bracketStack.peek() != '['){
                    result = 0;
                    break;
                }
                if (bracket.charAt(i-1) == '[') result += term;
                bracketStack.pop();
                term /= 3;
            }
        }
        if (!bracketStack.isEmpty()) System.out.println(0);
        else System.out.println(result);
    }
}