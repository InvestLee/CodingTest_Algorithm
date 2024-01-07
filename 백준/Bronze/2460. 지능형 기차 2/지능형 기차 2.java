import java.io.*;
import java.util.*;

//2460 지능형 기차 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int customers = 0;
        int result = 0;
        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());
            customers -= Integer.parseInt(st.nextToken());
            customers += Integer.parseInt(st.nextToken());
            result = Math.max(result, customers);
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}