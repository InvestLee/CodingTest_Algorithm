import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] visited = new boolean[1000001];
        for (int i = 2; i < (int) Math.sqrt(visited.length) + 1; i++){
            if (!visited[i]) {
                int j = 2;
                while (i * j < visited.length) {
                    visited[i * j] = true;
                    j++;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            boolean goldbach = false;
            for (int i = 3; i < n/2+1; i++){
                if (!visited[i] && !visited[n-i]){
                    goldbach = true;
                    System.out.printf("%d = %d + %d\n", n, i, n-i);
                    break;
                }
            }
            if (!goldbach) System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}