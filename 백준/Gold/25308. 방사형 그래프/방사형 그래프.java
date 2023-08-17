import java.io.*;
import java.util.*;

//백준 25308 방사형 그래프
public class Main {

    public static double[] stat, changeStat;
    public static boolean[] visited;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        stat = new double[8];
        changeStat = new double[8];
        visited = new boolean[8];
        for(int i = 0; i < 8; i++) stat[i] = Integer.parseInt(st.nextToken());
        changeStat[0] = stat[0];

        result = 0;
        dfs(1);

        bw.write(result * 8 + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int check(){
        int idx1, idx2;
        for(int i = 0; i < 8; i++){
            idx1 = (i + 1) % 8;
            idx2 = (i + 2) % 8;
            if(changeStat[i] * changeStat[idx2] * Math.sqrt(2) > changeStat[idx1] * (changeStat[i] + changeStat[idx2])){
                return 0;
            }
        }
        return 1;
    }

    public static void dfs(int cnt){
        if(cnt == 8){
            result += check();
            return;
        }

        for(int i = 1; i < 8; i++){
            if(visited[i]) continue;
            visited[i] = true;
            changeStat[cnt] = stat[i];
            dfs(cnt+1);
            visited[i] = false;
        }
    }
}
