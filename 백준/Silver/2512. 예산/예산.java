import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] need_budget = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            need_budget[i] = Integer.parseInt(st.nextToken());
        }
        //시간복잡도를 위해 이분탐색으로 값을 찾는다. 이를 위해 정렬
        Arrays.sort(need_budget);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        br.close();

        //이분 탐색
        int left = 0;
        int right = need_budget[N-1];
        while (left <= right){
            int total_budget = 0; //상한액에 따른 총 필요 예산
            int mid = (left+right)/2; //상한액
            for (int i = 0; i < N; i++){
                if (mid < need_budget[i]) total_budget += mid;
                else total_budget += need_budget[i];
            }
            if (total_budget > M) right = mid-1; //총량 초과
            else left = mid+1; //총량 도달하지 못함
        }
        //예산의 최대 금액(right) 출력
        System.out.println(right);
    }
}