import java.io.*;
import java.util.*;

//16199 나이 계산하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        a[0] = Integer.parseInt(st.nextToken());
        a[1] = Integer.parseInt(st.nextToken());
        a[2] = Integer.parseInt(st.nextToken());

        int[] b = new int[3];
        st = new StringTokenizer(br.readLine());
        b[0] = Integer.parseInt(st.nextToken());
        b[1] = Integer.parseInt(st.nextToken());
        b[2] = Integer.parseInt(st.nextToken());

        if(b[1] > a[1] || (b[1] == a[1] && b[2] >= a[2])) bw.write(b[0]-a[0]+"\n");
        else bw.write(b[0]-a[0]-1+"\n");

        bw.write(1+b[0]-a[0]+"\n");
        bw.write(b[0]-a[0]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}