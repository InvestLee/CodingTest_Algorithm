import java.io.*;
import java.util.*;

public class Main {

    public static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[]{n, 0});
        boolean[] visited = new boolean[100_001];

        int result = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowPosition = now[0];
            result = now[1];

            if (nowPosition == k) {
                break;
            }

            visited[nowPosition] = true;
            if (nowPosition * 2 <= 100_000 && !visited[nowPosition * 2]) {
                pq.offer(new int[] {nowPosition * 2, result});
            }

            if (nowPosition < k && nowPosition + 1 <= 100_000 && !visited[nowPosition + 1]) {
                pq.offer(new int[] {nowPosition + 1, result + 1});
            }

            if (nowPosition - 1 >= 0  && !visited[nowPosition - 1]) {
                pq.offer(new int[] {nowPosition - 1, result + 1});
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
