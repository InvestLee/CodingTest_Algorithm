import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int[] select;
    public static boolean[] isTeam;
    public static boolean[] visited;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            result = 0;
            int n = Integer.parseInt(br.readLine());
            select = new int[n+1];
            isTeam = new boolean[n+1];
            visited = new boolean[n+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) select[i] = Integer.parseInt(st.nextToken());
            for(int i = 1; i <= n; i++) if(!isTeam[i]) dfs(i);
            System.out.println(n-result);
        }
    }

    public static void dfs(int idx){
        visited[idx] = true;
        int nextStudent = select[idx];
        if(!visited[nextStudent]) dfs(nextStudent);
        else{
            if(!isTeam[nextStudent]){
                result++;
                isTeam[nextStudent] = true;
                while(nextStudent != idx){
                    result++;
                    nextStudent = select[nextStudent];
                    isTeam[nextStudent] = true;
                }
            }
        }
        isTeam[idx] = true;
    }
}