import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        Arrays.sort(arr, Comparator.reverseOrder());
        int result = 0; //버틸 수 있는 로프 중량 최댓값
        int temp; //해당 지점에서 견딜 수 있는 로프 중량
        for (int i = 0; i < N ; i++){
            temp = arr[i] * (i+1);
            if (result < temp) result = temp;
        }
        System.out.println(result);
    }
}