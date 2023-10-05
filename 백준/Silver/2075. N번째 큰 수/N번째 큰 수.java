import java.io.*;
import java.util.*;

//백준 2075 N번째 큰 수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < n-1; i++){
            pq.poll();
        }

        bw.write(pq.poll()+"");
        bw.flush();
        br.close();
        bw.close();
    }
}