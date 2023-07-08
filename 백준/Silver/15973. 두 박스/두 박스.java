import java.io.*;
import java.util.*;

//백준 15973 두 박스
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int x1, y1, p1, q1, x2, y2, p2, q2;
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        p1 = Integer.parseInt(st.nextToken());
        q1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        q2 = Integer.parseInt(st.nextToken());
        if(p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1){
            bw.write("NULL");
        } else if((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2)){
            bw.write("POINT");
        } else if(p1 == x2 || q1 == y2|| p2 == x1 || y1 == q2){
            bw.write("LINE");
        } else {
            bw.write("FACE");
        }

        bw.flush();
        bw.close();
    }
}
