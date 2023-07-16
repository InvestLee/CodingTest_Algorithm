import java.io.*;
import java.util.*;

//백준 2022 사다리
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double left = 0;
        double right = Math.min(x,y);

        double mid, xh, yh, cal;
        while(right - left >= 0.001){
            mid = (left+right) / 2;
            xh = Math.sqrt(Math.pow(x,2) - Math.pow(mid,2));
            yh = Math.sqrt(Math.pow(y,2) - Math.pow(mid,2));
            cal = (xh * yh) / (xh + yh);

            if(cal >= c) left = mid;
            else right = mid;
        }

        bw.write(String.format("%.3f", right));
        bw.flush();
        bw.close();
    }
}
