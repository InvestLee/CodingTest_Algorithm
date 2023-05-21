import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean reverse = true;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '<') {
                while(!stack.isEmpty()) bw.write(stack.pop());
                reverse = false;
            }
            else if(s.charAt(i) == '>'){
                reverse = true;
                bw.write(s.charAt(i));
                continue;
            }

            if(!reverse) bw.write(s.charAt(i));
            else{
                if(s.charAt(i) == ' '){
                    while(!stack.isEmpty()) bw.write(stack.pop());
                    bw.write(" ");
                    continue;
                }
                else stack.push(s.charAt(i));
            }

            if(i == s.length()-1){
                while(!stack.isEmpty()) bw.write(stack.pop());
            }
        }
        bw.write("");
        bw.flush();
        bw.close();
    }
}
