import java.io.*;
import java.util.StringTokenizer;

//1547 공
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int x, y;
        int result = 1;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if(x == result) result = y;
            else if(y == result) result = x;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}