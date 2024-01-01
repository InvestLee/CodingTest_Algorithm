import java.io.*;
import java.util.*;

//2506 점수계산
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int temp = 0;
        int result = 0;
        for(int i = 0; i < n; i++){
            if(Integer.parseInt(st.nextToken()) == 1) temp++;
            else temp = 0;
            result += temp;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}