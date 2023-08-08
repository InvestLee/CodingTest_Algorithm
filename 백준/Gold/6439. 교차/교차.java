import java.io.*;
import java.util.*;

//백준 6493 교차
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        long xStart, yStart, xEnd, yEnd, x1, y2, x2, y1, temp;
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            xStart = Long.parseLong(st.nextToken());
            yStart = Long.parseLong(st.nextToken());
            xEnd = Long.parseLong(st.nextToken());
            yEnd = Long.parseLong(st.nextToken());
            x1 = Long.parseLong(st.nextToken());
            y2 = Long.parseLong(st.nextToken());
            x2 = Long.parseLong(st.nextToken());
            y1 = Long.parseLong(st.nextToken());

            if(x1>x2){
                temp = x1;
                x1 = x2;
                x2 = temp;
            }
            if(y1>yEnd){
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
            if(isCross(xStart, yStart, xEnd, yEnd, x1, y1, x1, y2) ||
                    isCross(xStart, yStart, xEnd, yEnd, x1, y2, x2, y2) ||
                    isCross(xStart, yStart, xEnd, yEnd, x2, y2, x2, y1) ||
                    isCross(xStart, yStart, xEnd, yEnd, x2, y1, x1, y1) ||
                    ((x1 < xStart && x1 < xEnd && x2 > xStart && x2 > xEnd) &&
                            (y1 < yStart && y1 < yEnd && y2 > yStart && y2 > yEnd))) bw.write("T\n");
            else bw.write("F\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static long ccw(long x1, long y1, long x2, long y2, long x3, long y3){
        long result = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if(result < 0) return -1;
        else if(result > 0) return 1;
        else return 0;
    }

    public static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
        if(ccw(x1,y1,x2,y2,x3,y3) * ccw(x1,y1,x2,y2,x4,y4) <= 0 &&
                ccw(x3,y3,x4,y4,x1,y1) * ccw(x3,y3,x4,y4,x2,y2) <= 0){
            if((x1 < x3 && x1 < x4 && x2 < x3 && x2 < x4)||
                    (x3 < x1 && x3 < x2 && x4 < x1 && x4 < x2)) return false;
            else if((y1 < y3 && y1 < y4 && y2 < y3 && y2 < y4)||
                    (y3 < y1 && y3 < y2 && y4 < y1 && y4 < y2)) return false;
            return true;
        }
        return false;
    }
}
