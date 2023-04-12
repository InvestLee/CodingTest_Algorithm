import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] sumArr = new long[n+1];
        long[] idxArr = new long[m];
        long result = 0;
        int tempNum;

        st = new StringTokenizer(br.readLine());
        for ( int i = 1; i <= n; i++){
            tempNum = Integer.parseInt(st.nextToken());
            sumArr[i] = (sumArr[i-1] + tempNum) % m;
            if(sumArr[i] == 0) result++;
            idxArr[(int) sumArr[i]]++;
        }

        for(int i = 0; i < m; i++) {
            if (idxArr[i] > 1) {
                result += (idxArr[i] * (idxArr[i]-1)/2);
            }
        }
        System.out.println(result);
    }
}