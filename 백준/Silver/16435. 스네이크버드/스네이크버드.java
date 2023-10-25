import java.io.*;
import java.util.*;

//백준 16435 스네이크버드
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] fruit = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) fruit[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(fruit);

        for(int i = 0; i < n; i++){
            if(fruit[i] > l) break;
            l++;
        }

        bw.write(l+"");
        bw.flush();
        br.close();
        bw.close();
    }
}