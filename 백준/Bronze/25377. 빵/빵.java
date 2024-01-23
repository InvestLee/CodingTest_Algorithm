import java.io.*;
import java.util.StringTokenizer;

//25377 빵
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int a, b;
        int result = 1001;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a <= b) result = Math.min(result, Math.max(a,b));
        }

        if(result == 1001) bw.write("-1");
        else bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}