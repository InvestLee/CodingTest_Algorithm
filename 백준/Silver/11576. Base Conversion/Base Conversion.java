import java.io.*;
import java.util.*;

//백준 11576 Base Conversion
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        int total = 0;

        for(int i = m - 1; i >= 0; i--){
            total += Integer.parseInt(st.nextToken()) * Math.pow(a,i);
        }

        while(total != 0){
            stack.push(total % b);
            total /= b;
        }

        while(!stack.isEmpty()){
            bw.write(stack.pop()+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}