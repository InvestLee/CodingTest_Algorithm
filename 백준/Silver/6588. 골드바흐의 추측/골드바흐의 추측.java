import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int r,c,n;
    public static char[][] graph;
    public static Queue<int[]> q = new LinkedList<>();
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, j;
        boolean isGoldbach;
        boolean[] isPrime = new boolean[1000001];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i <= (int) Math.sqrt(1000001); i++){
            j = 2;
            while (i*j<1000001) {
                isPrime[i * j] = true;
                j++;
            }
        }

        while (true){
            n = Integer.parseInt(br.readLine());
            if (n==0) break;
            isGoldbach = false;
            for (int i = 2; i <= n/2; i++){
                if(!isPrime[i] && !isPrime[n-i]){
                    System.out.println(n + " = " + i + " + " + (n - i));
                    isGoldbach = true;
                    break;
                }
            }
            if (!isGoldbach) System.out.println("Goldbach's conjecture is wrong.");
        }

    }
}