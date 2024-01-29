import java.io.*;
import java.util.StringTokenizer;

//9325 얼마?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int s, n, q, p;
        while(t-- > 0){
            s = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            while(n-- > 0){
                st = new StringTokenizer(br.readLine());
                q = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());
                s += q*p;
            }
            bw.write(s+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}