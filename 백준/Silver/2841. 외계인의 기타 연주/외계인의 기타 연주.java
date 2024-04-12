import java.io.*;
import java.util.*;

//2841 외계인의 기타 연주
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        Stack<Integer>[] stack = new Stack[7];
        for(int i = 1; i < 7; i++) stack[i] = new Stack<>();

        int line, flat, result = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            line = Integer.parseInt(st.nextToken());
            flat = Integer.parseInt(st.nextToken());

            while(!stack[line].isEmpty()){
                if(stack[line].peek() < flat) stack[line].push(flat);
                else if(stack[line].peek() > flat) stack[line].pop();
                else break;
                result++;
            }
            if(stack[line].isEmpty()){
                stack[line].push(flat);
                result++;
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}
