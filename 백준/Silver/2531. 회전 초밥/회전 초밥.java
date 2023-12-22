import java.io.*;
import java.util.*;

//2531 회전 초밥
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        int[] ate = new int[d+1];
        ate[c] = 3001;
        int eatCnt = 1;
        for(int i = 0; i < n; i++) sushi[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++){
            if(ate[sushi[i]]==0) eatCnt++;
            ate[sushi[i]]++;
        }

        int result = eatCnt;
        int start, end;
        for(int i = 0; i < n-1; i++){
            start = sushi[i];
            end = sushi[(i+k)%n];
            if(--ate[start] == 0) eatCnt--;
            if(++ate[end] == 1) eatCnt++;
            result = Math.max(result, eatCnt);
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}