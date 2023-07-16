import java.io.*;
import java.util.*;

//백준 17386 선분 교차 1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        int result = 0;
        if(ccw(x1,y1,x2,y2,x3,y3) * ccw(x1,y1,x2,y2,x4,y4) < 0 &&
                ccw(x3,y3,x4,y4,x1,y1) * ccw(x3,y3,x4,y4,x2,y2) < 0) result = 1;

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3){
        long result = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if(result < 0) return 1;
        else return -1;
    }
}
