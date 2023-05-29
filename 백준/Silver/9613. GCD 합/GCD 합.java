import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int n, a, b, tmp;
        long result;
        Integer[] arr;
        StringTokenizer st;

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new Integer[n];
            result = 0;
            for(int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr, Collections.reverseOrder());
            for(int j = 0; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    a = arr[j];
                    b = arr[k];
                    while(b!=0){
                        tmp = a%b;
                        a = b;
                        b = tmp;
                    }
                    result += a;
                }
            }
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
}
