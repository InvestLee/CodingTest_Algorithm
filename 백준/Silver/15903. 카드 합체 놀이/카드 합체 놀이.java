import java.io.*;
import java.util.*;

//백준 15903 카드 합체 놀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) pq.add(Long.parseLong(st.nextToken()));

        long a, b, total;
        for(int i = 0; i < m; i++){
            a = pq.poll();
            b = pq.poll();
            total = a + b;
            pq.add(total);
            pq.add(total);
        }

        long result = 0;
        for(int i = 0; i < n; i++) result += pq.poll();

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}