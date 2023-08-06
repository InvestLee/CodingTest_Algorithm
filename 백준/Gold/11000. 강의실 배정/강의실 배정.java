import java.io.*;
import java.util.*;

//백준 11000 강의실 배정
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] lecture = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            lecture[i][0] = Integer.parseInt(st.nextToken());
            lecture[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lecture, ((o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        }));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lecture[0][1]);

        for(int i = 1; i < n; i++){
            if(pq.peek() <= lecture[i][0]) pq.poll();
            pq.offer(lecture[i][1]);
        }

        bw.write(pq.size()+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
