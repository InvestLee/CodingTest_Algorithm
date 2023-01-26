import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min_input = Long.valueOf(st.nextToken());
        long max_input = Long.valueOf(st.nextToken());
        int range = (int) (max_input-min_input+1);
        boolean[] chamber = new boolean[range];

        long start;
        for (long i = 2; i <= (long) Math.sqrt(max_input); i++){
            long pow_num = i*i;
            if (min_input % pow_num == 0) start = min_input / pow_num;
            else start = min_input / pow_num + 1;
            for (long j = start; j * pow_num <= max_input; j++ ){
                chamber[(int) (j*pow_num-min_input)] = true;
            }
        }
        int result = 0;
        for (int i = 0; i < range; i++){
            if(!chamber[i]) result++;
        }
        System.out.println(result);
    }
}