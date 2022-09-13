import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] garo_tree = new int[N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            garo_tree[i] = Integer.parseInt(st.nextToken());
        }
        //가로수 간 거리 간의 최대공약수 계산
        Arrays.sort(garo_tree);
        BigInteger gcd_num = new BigInteger(String.valueOf(garo_tree[1]-garo_tree[0]));
        for (int i = 1; i < N-1; i++){
            gcd_num = gcd_num.gcd(BigInteger.valueOf(garo_tree[i+1]-garo_tree[i]));
        }
        //((가장 먼 위치 - 가장 가까운 위치)/최대공약수) + 1 - 이미 심어진 가로수 수 = 심어야 하는 가로수
        System.out.println((garo_tree[N-1]-garo_tree[0])/Integer.parseInt(String.valueOf(gcd_num))+1-N);
        br.close();
    }
}