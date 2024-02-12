import java.io.*;
import java.util.StringTokenizer;

//2355 시그마
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long result;
        if(a > b){
            result = (a+b) * (a-b+1) / 2;
        } else {
            result = (a+b) * (b-a+1) / 2;
        }

        bw.write(result+ "");
        bw.flush();
        bw.close();
        br.close();
    }
}