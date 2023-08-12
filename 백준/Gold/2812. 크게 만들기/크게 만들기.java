import java.io.*;
import java.util.*;

//백준 2812 크게 만들기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] num = br.readLine().toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            while(k > 0 && !dq.isEmpty() && dq.getLast() < num[i]){
                dq.removeLast();
                k--;
            }
            dq.addLast(num[i]);
        }

        StringBuilder sb = new StringBuilder();
        while(dq.size() > k) sb.append(dq.removeFirst());

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
