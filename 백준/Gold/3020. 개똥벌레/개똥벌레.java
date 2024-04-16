import java.io.*;
import java.util.*;

//3020 개똥벌레
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] down = new int[h+1];
        int[] up = new int[h+1];

        for(int i = 0; i < n/2; i++){
            down[Integer.parseInt(br.readLine())]++;
            up[h-Integer.parseInt(br.readLine())+1]++;
        }

        for(int i = h-1; i >= 1; i--) down[i] += down[i+1];
        for(int i = 2; i <= h; i++) up[i] += up[i-1];

        int result = n;
        int brokenObject, cnt = 0;

        for(int i = 1; i <= h; i++){
            brokenObject = down[i] + up[i];
            if(brokenObject < result){
                result = brokenObject;
                cnt = 1;
            } else if(brokenObject == result) {
                cnt++;
            }
        }

        bw.write(result+" "+cnt);
        bw.flush();
    }
}
