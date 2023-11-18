import java.io.*;
import java.util.*;

//백준 2776 암기왕
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n, m, num;
        HashSet<Integer> hashSet;
        StringTokenizer st;

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            hashSet = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                hashSet.add(Integer.parseInt(st.nextToken()));
            }
            m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                num = Integer.parseInt(st.nextToken());
                if(hashSet.contains(num)) bw.write("1\n");
                else bw.write("0\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}