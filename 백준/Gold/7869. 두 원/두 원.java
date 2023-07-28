import java.io.*;
import java.util.*;

//백준 7869 두 원
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double r1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double r2 = Double.parseDouble(st.nextToken());
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double result = 0;

        double angle1, angle2, area1, area2;
        if(r1 + r2 > distance){
            if(Math.abs(r1 - r2) >= distance){
                result = Math.PI * Math.pow(Math.min(r1,r2),2);
            } else {
                angle1 = Math.acos((r1 * r1 + distance * distance - r2 * r2) / (2 * r1 * distance));
                angle2 = Math.acos((r2 * r2 + distance * distance - r1 * r1) / (2 * r2 * distance));
                area1 = (r1 * r1 * angle1) - (r1 * r1 * Math.sin(2 * angle1) / 2);
                area2 = (r2 * r2 * angle2) - (r2 * r2 * Math.sin(2 * angle2) / 2);
                result = area1 + area2;
            }
        }

        bw.write(String.format("%.3f", result));
        br.close();
        bw.flush();
        bw.close();
    }
}