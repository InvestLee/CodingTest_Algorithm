import java.io.*;
import java.util.*;

//백준 1417 국회의원 선거
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(n-- > 1) pq.add(Integer.parseInt(br.readLine()));

        int result = 0;
        while(!pq.isEmpty() && pq.peek() >= target){
            result++;
            target++;
            pq.add(pq.poll()-1);
        }
        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}