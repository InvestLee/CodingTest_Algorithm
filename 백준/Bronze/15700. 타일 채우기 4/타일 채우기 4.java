import java.io.*;
import java.util.*;

//백준 15700 타일 채우기 4
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        bw.write((n*m)/2+"");
        bw.flush();
        br.close();
        bw.close();
    }
}