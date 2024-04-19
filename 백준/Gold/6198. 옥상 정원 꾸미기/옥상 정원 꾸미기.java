import java.io.*;
import java.util.*;

//6198 옥상 정원 꾸미기
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long result = 0;
        int h;
        for (int i = 0; i < n; i++){
            h = Integer.parseInt(br.readLine());
            while(!stack.isEmpty()){
                if(stack.peek() <= h) stack.pop();
                else break;
            }
            result += stack.size();
            stack.push(h);
        }
        bw.write(result+"");
        bw.flush();
    }
}
