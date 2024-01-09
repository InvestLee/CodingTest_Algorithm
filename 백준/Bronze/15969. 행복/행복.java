import java.io.*;
import java.util.*;

//15969 행복
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxVal = -1;
        int minVal = 1001;
        int num;
        for(int i = 0; i < n; i++){
            num = Integer.parseInt(st.nextToken());
            if(maxVal < num) maxVal = num;
            if(minVal > num) minVal = num;
        }

        bw.write(maxVal-minVal+"");
        bw.flush();
        bw.close();
        br.close();
    }
}