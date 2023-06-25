import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int n;
        double total, avg, overAvg;
        ArrayList<Integer> arr;
        while(c-- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new ArrayList<>();
            total = 0;
            overAvg = 0;
            for(int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
                total += arr.get(i);
            }
            avg = total / n;
            for(int i = 0; i < n; i++) {
                if(arr.get(i) > avg) overAvg++;
            }
            bw.write(String.format("%.3f",overAvg/n*100)+"%\n");
        }
        bw.flush();
        bw.close();
    }
}
