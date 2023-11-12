import java.io.*;
import java.util.*;

//백준 1922 네트워크 연결
public class Main {
    public static int parents[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parents = new int[n+1];
        for(int i = 0; i < n+1; i++) parents[i] = i;

        int networks[][] = new int[m][3];
        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            networks[i][0] = Integer.parseInt(st.nextToken());
            networks[i][1] = Integer.parseInt(st.nextToken());
            networks[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(networks, Comparator.comparingInt(o -> o[2]));

        int result = 0;
        for(int[] network : networks){
            if(union(network[0],network[1])) result += network[2];
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parents[a] = b;
            return true;
        }
        return false;
    }
}