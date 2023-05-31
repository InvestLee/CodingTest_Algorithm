import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<Character> stack;
        String word;

        while(n-- > 0){
            word = br.readLine();
            stack = new Stack<>();
            for(int i = 0; i < word.length(); i++){
                if(!stack.isEmpty() && stack.get(stack.size()-1) == word.charAt(i)) stack.pop();
                else stack.add(word.charAt(i));
            }
            if(stack.isEmpty()) result++;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
