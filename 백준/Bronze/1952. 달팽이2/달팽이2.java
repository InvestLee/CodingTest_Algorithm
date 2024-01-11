import java.io.*;
import java.util.*;

//1952 달팽이 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        if(m == n || m < n) bw.write(2*(m-1)+"");
        else bw.write(2*(n-1)+1+"");

        bw.flush();
        bw.close();
        br.close();
    }
}