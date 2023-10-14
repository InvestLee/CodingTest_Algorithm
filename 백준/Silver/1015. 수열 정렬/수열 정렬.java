import java.io.*;
import java.util.*;

//백준 1015 수열 정렬
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = a[i];
        }
        Arrays.sort(b);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i] == b[j]){
                    bw.append(j+" ");
                    b[j] = -1;
                    break;
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}