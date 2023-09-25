import java.io.*;
import java.util.*;

//백준 1297 TV 크기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        double multi =  (double) d*d / (double)(h*h+w*w);
        int resultH = (int) Math.sqrt(h * h * multi);
        int resultW = (int) Math.sqrt(w * w * multi);

        bw.write(resultH+" "+resultW);

        bw.flush();
        br.close();
        bw.close();
    }
}