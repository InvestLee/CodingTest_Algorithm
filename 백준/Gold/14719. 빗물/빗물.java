import java.io.*;
import java.util.*;

//백준 14719 빗물
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] block = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int left, right;
        for(int i = 1; i < w-1; i++){
            left = 0;
            right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(block[j],left);
            }

            for(int j = i+1; j < w; j++) {
                right = Math.max(block[j],right);
            }

            if(block[i] < left && block[i] < right) {
                result += Math.min(left,right) - block[i];
            }
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}