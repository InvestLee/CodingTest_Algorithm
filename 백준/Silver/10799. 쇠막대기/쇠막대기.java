import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String razor = br.readLine();
        Stack<Character> stack = new Stack<>();
        stack.push(razor.charAt(0));
        int result = 0;
        for(int i = 1; i < razor.length(); i++){
            if(razor.charAt(i) == '(') stack.push(razor.charAt(i));
            else {
                stack.pop();
                if(razor.charAt(i-1) == '(') result += stack.size();
                else result++;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
