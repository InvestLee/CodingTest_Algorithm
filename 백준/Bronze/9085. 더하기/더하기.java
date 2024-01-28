import java.io.*;
import java.util.StringTokenizer;

//9085 더하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int n, result;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            result = 0;
            st = new StringTokenizer(br.readLine());
            while(n-- > 0){
                result += Integer.parseInt(st.nextToken());
            }
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}