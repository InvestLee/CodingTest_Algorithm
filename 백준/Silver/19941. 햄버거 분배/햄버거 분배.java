import java.io.*;
import java.util.*;

//19941 햄버거 분배
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        boolean[] visited = new boolean[n];
        int result = 0;

        for(int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if (j >= n) break;
                    if (j < 0) continue;
                    if (arr[j] == 'H' && !visited[j]) {
                        visited[j] = true;
                        result++;
                        break;
                    }
                }
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}
