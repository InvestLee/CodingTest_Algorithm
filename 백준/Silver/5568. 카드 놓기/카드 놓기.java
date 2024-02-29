import java.io.*;
import java.util.*;

//5568 카드 놓기
public class Main {

    public static int n, k;
    public static String[] arr;
    public static HashSet<String> chk = new HashSet<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }
        visited = new boolean[n];
        bf(0,"");
        bw.write(chk.size()+"");
        bw.flush();
        bw.close();
    }

    public static void bf(int cnt, String cur){
        if(cnt == k){
            chk.add(cur);
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            bf(cnt+1, cur+arr[i]);
            visited[i] = false;
        }
    }
}