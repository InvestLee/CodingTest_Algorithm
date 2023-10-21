import java.io.*;
import java.util.*;

//백준 1453 피시방 알바
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<Integer> hashSet = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num;
        for(int i = 0; i < n; i++){
            num = Integer.parseInt(st.nextToken());
            if(hashSet.contains(num)) result++;
            else hashSet.add(num);
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}