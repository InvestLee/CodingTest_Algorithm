import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int rowCnt = 0;
        int colCnt = 0;
        String[] floor = new String[n];

        for (int i = 0; i < n; i++){
            floor[i] = br.readLine();
            for (int j = 0; j < m; j++){
                if(floor[i].charAt(j) == 'X'){
                    rowCnt += 1;
                    break;
                }
            }
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(floor[j].charAt(i) == 'X'){
                    colCnt += 1;
                    break;
                }
            }
        }
        System.out.println(Math.max(n-rowCnt, m-colCnt));
    }
}
