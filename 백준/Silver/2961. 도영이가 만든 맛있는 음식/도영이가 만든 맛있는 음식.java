import java.io.*;
import java.util.*;

//2961 도영이가 만든 맛있는 음식
public class Main {

    public static int[] sour;
    public static int[] bitter;
    public static int result = Integer.MAX_VALUE;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        sour = new int[n];
        bitter = new int[n];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,1,0);
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int input, int cnt, int sour_multi, int bitter_sum){
        if(cnt == n){
            if(input != 0){
                result = Math.min(result, Math.abs(sour_multi-bitter_sum));
            }
            return;
        }
        dfs(input, cnt+1, sour_multi, bitter_sum);
        dfs(input+1, cnt+1, sour_multi*sour[cnt], bitter_sum+bitter[cnt]);
    }
}