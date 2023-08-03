import java.io.*;
import java.util.*;

//백준 1715 카드 정렬하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) pq.add(Long.parseLong(br.readLine()));

        long a, b;
        long result = 0;
        while(pq.size() > 1){
            a = pq.poll();
            b = pq.poll();
            result += (a + b);
            pq.add(a+b);
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
