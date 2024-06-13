import java.io.*;
import java.util.*;

//17356 욱 제
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double m = (b - a) / 400;
        double result = 1 / (1 + Math.pow(10,m));
        bw.write(result+"");
        bw.flush();
    }
}