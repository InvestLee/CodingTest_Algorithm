import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int[] count;
    public static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        count = new int[7];
        int countSum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0){
            int remainWork = Integer.parseInt(st.nextToken());
            if (remainWork % 7 == 0) continue;
            count[remainWork % 7]++;
            countSum++;
        }
        if (count[4] != 0 || countSum >= 6){
            System.out.println("YES");
            return;
        }
        dfs(0);
        if(check) System.out.println("YES");
        else System.out.println("NO");
    }
    public static void  dfs(int sum){
        if (sum % 7 == 4){
            check = true;
            return;
        }
        for (int i = 1; !check && i <= 6; i++){
            if(count[i] == 0) continue;
            count[i]--;
            dfs(sum+i);
            count[i]++;
        }
    }
}