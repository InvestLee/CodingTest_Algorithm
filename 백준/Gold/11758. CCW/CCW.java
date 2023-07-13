import java.io.*;
import java.util.*;

//백준 11758 CCW
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        int line1 = x1 * y2 + x2 * y3 + x3 * y1;
        int line2 = y1 * x2 + y2 * x3 + y3 * x1;

        int result;
        if(line1 - line2 > 0) result = 1;
        else if(line1 == line2) result = 0;
        else result = -1;

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
