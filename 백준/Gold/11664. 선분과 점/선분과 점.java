import java.io.*;
import java.util.*;

//백준 11664 선분과 점
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double ax = Double.parseDouble(st.nextToken());
        double ay = Double.parseDouble(st.nextToken());
        double az = Double.parseDouble(st.nextToken());
        double bx = Double.parseDouble(st.nextToken());
        double by = Double.parseDouble(st.nextToken());
        double bz = Double.parseDouble(st.nextToken());
        double cx = Double.parseDouble(st.nextToken());
        double cy = Double.parseDouble(st.nextToken());
        double cz = Double.parseDouble(st.nextToken());

        double mx, my, mz;
        double result = Double.MAX_VALUE;
        while(true){
            mx = (ax+bx)/2;
            my = (ay+by)/2;
            mz = (az+bz)/2;
            if(Math.abs(result-cal(mx,my,mz,cx,cy,cz)) <= Math.pow(10,-6)) break;
            if(cal(mx,my,mz,cx,cy,cz) < result) result = cal(mx,my,mz,cx,cy,cz);
            if(cal(ax,ay,az,cx,cy,cz) < cal(bx,by,bz,cx,cy,cz)){
                bx = mx;
                by = my;
                bz = mz;
            } else {
                ax = mx;
                ay = my;
                az = mz;
            }
        }

        bw.write(String.format("%.10f",result));
        bw.flush();
        br.close();
        bw.close();
    }

    public static double cal(double x1, double y1, double z1, double x2, double y2, double z2){
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)+Math.pow(z2-z1,2));
    }
}
