import java.io.*;
import java.util.*;

//백준 2437 저울
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] weight = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) weight[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(weight);

        int result = 0;
        for(int i = 0; i < n; i++){
            if(result +1 < weight[i]) break;
            result += weight[i];
        }

        bw.write(result+1+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
