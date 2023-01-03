import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Stack<Character> output = new Stack<>();
        while (n > 0){
            int next_num = n % b;
            if (next_num < 10) output.push((char) (n%b + '0'));
            else output.push((char) (n%b + 'A' - 10));
            n /= b;
        }
        while (!output.isEmpty()) System.out.print(output.pop());
    }
}