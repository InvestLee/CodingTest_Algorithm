import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<String> stack;

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            stack = new Stack<>();
            bw.write("Case #"+i+": ");
            while(st.countTokens() > 0) stack.add(st.nextToken());
            while(!stack.isEmpty()) bw.write(stack.pop()+" ");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
