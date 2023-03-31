import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder n = new StringBuilder(st.nextToken());
        n.reverse();
        int b = Integer.parseInt(st.nextToken());
        int result = 0;
        int target;
        for (int i = 0; i < n.length(); i++){
            target = (int) n.charAt(i);
            if (target < 58){
                result += (target-48) * Math.pow(b,i);
            } else {
                result += (target-55) * Math.pow(b,i);
            }
        }
        System.out.println(result);
    }
}