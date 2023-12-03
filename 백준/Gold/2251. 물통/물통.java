import java.io.*;
import java.util.*;

//2251 물통
public class Main {

    public static int[] volume;
    public static boolean[][] check;
    public static TreeSet<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        volume = new int[3];
        check = new boolean[201][201];
        for(int i = 0; i < 3; i++) volume[i] = Integer.parseInt(st.nextToken());

        result = new TreeSet<>();
        dfs(0,0, volume[2]);

        for(int num : result) bw.write(num+" ");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int a, int b, int c){
        if(check[a][b]) return;

        if(a == 0) result.add(c);
        check[a][b] = true;

        if(a + b > volume[1]) dfs((a+b) - volume[1] , volume[1], c);
        else dfs(0, a + b, c);

        if(a + b > volume[0]) dfs(volume[0] , (a+b) - volume[0], c);
        else dfs(a+b, 0, c);

        if(a + c > volume[0]) dfs(volume[0] , b, a + c - volume[0]);
        else dfs(a+c, b, 0);

        if(b + c > volume[1]) dfs(a, volume[1], b + c - volume[1]);
        else dfs(a, b + c, 0);

        dfs(a, 0, b+c);
        dfs(0, b, a+c);
    }
}
