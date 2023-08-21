import java.io.*;
import java.util.*;

//백준 2212 센서
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] censor = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++) censor[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(censor);

        Integer[] cenDist = new Integer[n-1];
        for(int i = 0; i < n-1 ; i++) cenDist[i] = censor[i+1] - censor[i];

        Arrays.sort(cenDist, Collections.reverseOrder());
        int result = 0;
        for(int i = k-1; i < n-1 ; i++) result += cenDist[i];

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
