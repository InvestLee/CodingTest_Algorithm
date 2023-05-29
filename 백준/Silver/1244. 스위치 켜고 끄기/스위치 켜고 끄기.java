import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] switches = new int[n+1];
        for(int i = 1; i <= n; i++) switches[i] = Integer.parseInt(st.nextToken());
        int student = Integer.parseInt(br.readLine());

        int gender, num, decal;
        for(int i = 0; i < student; i++){
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            num =  Integer.parseInt(st.nextToken());
            if(gender == 1){
                for(int j = num; j <= n; j += num) switches[j] = switches[j]^1;
            } else {
                decal = 0;
                for(int j = 1; 0 < num-j && num+j <= n; j++){
                    if(switches[num-j] == switches[num+j]) decal++;
                    else break;
                }
                for(int j = num-decal; j <= num+decal; j++){
                    switches[j] = switches[j]^1;
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            bw.write(switches[i]+" ");
            if(i % 20 == 0) bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
