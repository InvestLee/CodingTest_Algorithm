//2143: 두 배열의 합
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static ArrayList<Integer> cumA;
    public static ArrayList<Integer> cumB;

    public static void main(String[] args) throws IOException {
        //입력단
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st =new StringTokenizer(br.readLine());
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());

        //배열 A 모든 부배열 합의 값
        int sum;
        cumA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                cumA.add(sum);
            }
        }

        //배열 B 모든 부배열의 합의 값
        cumB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                cumB.add(sum);
            }
        }

        //이분탐색
        cumA.sort(Comparator.naturalOrder());
        cumB.sort(Comparator.naturalOrder());
        long result = 0;
        int target;
        for (int aValue : cumA){
            target = t - aValue;
            result += (bisect_right(target)-bisect_left(target)); //cumB에 동일한 수가 있을 수 있으므로 동일한 수 갯수만큼 더함
        }
        System.out.println(result);
    }

    public static int bisect_left(int target){
        int start = 0;
        int end = cumB.size();
        int mid;
        while (start < end){
            mid = (start+end)/2;
            if(cumB.get(mid) >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    public static int bisect_right(int target){
        int start = 0;
        int end = cumB.size();
        int mid;
        while (start < end){
            mid = (start+end)/2;
            if(cumB.get(mid) > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}