import java.io.*;
import java.util.*;

//11549 Identifying tea
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for(int i = 0; i < 5; i++){
            if(t == Integer.parseInt(st.nextToken())) result++;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}