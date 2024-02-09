import java.io.*;

//1568 새
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        int cnt = 1;
        while(n > 0){
            if(cnt > n) cnt = 1;
            n -= cnt;
            cnt++;
            result++;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}