import java.io.*;
import java.util.*;

//2564 경비원
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int total = (w+h) << 1;
        int n = Integer.parseInt(br.readLine());

        int[] location = new int[n+1];
        int way;
        for(int i = 0; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            way = Integer.parseInt(st.nextToken());
            location[i] = Integer.parseInt(st.nextToken());

            if(way == 2) location[i] = w - location[i];
            else if(way == 3) location[i] = h - location[i];

            switch (way) {
                case 3: location[i] += w;
                case 2: location[i] += h;
                case 4: location[i] += w;
            }
        }

        int result = 0;
        int len;
        for(int i = 0; i < n; i++){
            len = Math.abs(location[n] - location[i]);
            result += Math.min(len,total - len);
        }
        bw.write(result+"");
        bw.flush();
    }
}
