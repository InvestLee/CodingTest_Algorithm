import java.io.*;
import java.util.*;

//백준 5800 성적 통계
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int[] scores;
        int n, largestGap;
        StringTokenizer st;
        for(int num = 1; num <= k; num++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            scores = new int[n];
            for(int i = 0; i < n; i++){
                scores[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores);
            largestGap = 0;
            for(int i = 0; i < n - 1; i++){
                largestGap = Math.max(largestGap, scores[i+1] - scores[i]);
            }
            bw.write("Class "+num+"\n");
            bw.write("Max "+scores[n-1]+", Min "+scores[0]+", Largest gap "+largestGap+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}