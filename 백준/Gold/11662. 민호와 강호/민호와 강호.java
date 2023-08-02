import java.io.*;
import java.util.*;

//백준 11662 민호와 강호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double ax = Double.parseDouble(st.nextToken());
        double ay = Double.parseDouble(st.nextToken());
        double bx = Double.parseDouble(st.nextToken());
        double by = Double.parseDouble(st.nextToken());
        double cx = Double.parseDouble(st.nextToken());
        double cy = Double.parseDouble(st.nextToken());
        double dx = Double.parseDouble(st.nextToken());
        double dy = Double.parseDouble(st.nextToken());

        double dx1 = (bx-ax)/1000000;
        double dy1 = (by-ay)/1000000;
        double dx2 = (dx-cx)/1000000;
        double dy2 = (dy-cy)/1000000;

        double min = calDistance(ax, ay, cx, cy);

        double temp;
        for(int i = 1; i <= 1000000; i++){
            temp = calDistance(ax + dx1*i,ay + dy1*i,cx + dx2*i,cy + dy2*i);
            min = Math.min(min,temp);
        }

        bw.write(String.format("%.10f",min));
        br.close();
        bw.flush();
        bw.close();
    }

    public static double calDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2));
    }
}