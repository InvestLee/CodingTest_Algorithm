import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int n;
    public static int arr[];
    public static boolean isChoice[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        isChoice = new boolean[n];
        dfs(0);
    }

    public static void dfs(int count){
        if (count == n){
            for (int i = 0; i < n; i++) System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++){
            if (!isChoice[i]){
                arr[count] = i+1;
                isChoice[i] = true;
                dfs(count+1);
                isChoice[i] = false;
            }
        }
    }
}