import java.io.*;
import java.util.*;

//17087 숨바꼭질 6
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Math.abs(Integer.parseInt(st.nextToken()) - s);
        }

        int result = arr[0];
        for(int i = 0; i < n; i++){
            result = gcd(result, arr[i]);
        }
        bw.write(result+"");
        bw.flush();
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
