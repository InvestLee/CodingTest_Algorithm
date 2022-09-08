import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int S;
    public static int[] arr;
    public static int result;
    
    public static void dfs(int sum_num, int depth){
        if (depth == N) {
            if (sum_num == S) result++;
            return;
        }
        //더한 경우 안더한 경우 구분
        dfs(sum_num+arr[depth],depth+1);
        dfs(sum_num,depth+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        result = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        if (S==0) System.out.println(result-1); //0은 스택 크기가 양수가 아니어도 한개 포함
        else System.out.println(result);
        br.close();
    }
}