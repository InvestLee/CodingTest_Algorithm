import java.io.*;
import java.util.StringTokenizer;

//13136 Do Not Touch Anything
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long x, y;

        if(r % n > 0) x = r/n + 1;
        else x = r/n;
        if(c % n > 0) y = c/n + 1;
        else y = c/n;

        bw.write(x*y+"");
        bw.flush();
        bw.close();
        br.close();
    }
}