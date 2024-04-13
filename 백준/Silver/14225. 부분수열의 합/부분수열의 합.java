import java.io.*;
import java.util.*;

//14225 부분수열의 합
public class Main {

    public static int[] num;
    public static int n;
    public static boolean[] visited;
    public static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        visited = new boolean[n];
        used = new boolean[100000 * 20 + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());
        dfs(0,0);
        for(int i = 1; i < used.length; i++){
            if(!used[i]){
                bw.write(i+"");
                break;
            }
        }
        bw.flush();
    }

    public static void dfs(int depth, int sum){
        if(depth == n){
            used[sum] = true;
            return;
        }
        dfs(depth+1, sum + num[depth]);
        dfs(depth+1, sum);
    }
}
