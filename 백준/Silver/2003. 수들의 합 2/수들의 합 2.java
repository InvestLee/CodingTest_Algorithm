import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int num_sum = arr[0];
        int left = 0;
        int right = 0;
        while (left < n){
            if (num_sum <= m){
                if (num_sum == m) result++;
                right++;
                if(right >= n) break;
                num_sum += arr[right];
            } else if (num_sum > m) {
                num_sum -= arr[left];
                left++;
            }
        }
        System.out.println(result);
    }
}