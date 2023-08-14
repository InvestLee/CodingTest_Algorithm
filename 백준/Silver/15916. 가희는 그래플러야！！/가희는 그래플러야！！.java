import java.io.*;
import java.util.*;

//백준 15916 가희는 그래플러야!!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n+1];
        for(int i = 1; i <= n; i++) arr[i] = Long.parseLong(st.nextToken());
        long k = Long.parseLong(br.readLine());

        String result = "F";
        if(arr[1] == k) result = "T";
        else{
            for(int i = 2; i <= n; i++){
                if(isIntersect(i-1,k*(i-1),i,k*i,i-1,arr[i-1],i,arr[i])){
                    result = "T";
                    break;
                }
            }
        }

        bw.write(result+"");
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

    public static boolean isIntersect(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
        if(ccw(x1,y1,x2,y2,x3,y3) * ccw(x1,y1,x2,y2,x4,y4) <= 0 &&
                ccw(x3,y3,x4,y4,x1,y1) * ccw(x3,y3,x4,y4,x2,y2) <= 0) return true;
        return false;
    }
}
