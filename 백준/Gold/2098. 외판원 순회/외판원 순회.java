import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int cannotCycle = 17 * 1000000 + 1;
    static final int notVisit = cannotCycle * 2;
    static int n;
    static int[][] in, dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        in = new int[n][n];
        dist = new int[n][ 1 << n ];

        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < n ; j ++) {
                in[i][j] = sc.nextInt();
            }
            Arrays.fill(dist[i], notVisit);
        }

        dist[0][0] = 0;
        System.out.println(tsp(0, 0));
    }

    static int tsp(int now, int visited) {
        visited = visited | (1<<now);

        if(visited == (1<<n) - 1) {
            if(in[now][0] == 0) {
                return cannotCycle;
            }
            return in[now][0];
        }

        if(dist[now][visited] != notVisit) {
            return dist[now][visited];
        }

        for(int next = 0 ; next < n ; next ++) {
            if(in[now][next] != 0) {
                if( ( visited & (1<<next) ) == 0) {


                    int temp = tsp(next, visited) + in[now][next];

                    if(dist[now][visited] > temp) {
                        dist[now][visited] = temp;
                    }
                }
            }
        }

        return dist[now][visited];
    }
}