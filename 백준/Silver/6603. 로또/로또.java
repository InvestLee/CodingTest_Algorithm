import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int k;
    public static Stack<String> stack = new Stack<>();
    public static String[] arr;

    //백트래킹 사용하여 로또의 경우의 수 출력
    public static void backtracking(int start){
        if (stack.size() == 6){
            System.out.println(String.join(" ", stack));
            return;
        }
        for (int i = start; i < k; i++){
            stack.add(arr[i]);
            backtracking(i+1);
            stack.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            arr = new String[k];
            if (k==0) break;
            for (int i = 0; i < k; i++){
                arr[i] = st.nextToken();
            }
            backtracking(0);
            System.out.println();
        }

        br.close();
    }
}