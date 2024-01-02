import java.io.*;
import java.util.*;

//2711 오타맨 고창영
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int num;
        String str;
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken()) - 1;
            str = st.nextToken();
            for(int j = 0; j < str.length(); j++){
                if(num == j) continue;
                bw.write(str.charAt(j)+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}