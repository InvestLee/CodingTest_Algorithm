import java.io.*;
import java.util.*;

//7795 먹을 것인가 먹힐 것인가
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int n, m;
        int[] aArr, bArr;
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            aArr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                aArr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(aArr);

            bArr = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                bArr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(bArr);

            int idx = 0;
            int result = 0;
            int low, high, mid;
            for(int i = 0; i < n; i++){
                low = 0;
                high = m-1;
                while(low <= high){
                    mid = (low+high)/2;
                    if(bArr[mid] < aArr[i]){
                        low = mid+1;
                        idx = mid+1;
                    } else {
                        high = mid-1;
                    }
                }
                if(idx >= m){
                    result += (n - i) * idx;
                    break;
                }
                result += idx;
            }
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}