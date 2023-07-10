import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        String temp;

        for(int i = 0; i < n; i++){
            temp = br.readLine();
            for(int j = 0; j < m; j++){
                a[i][j] = temp.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++){
            temp = br.readLine();
            for(int j = 0; j < m; j++){
                b[i][j] = temp.charAt(j) - '0';
            }
        }

        int result = 0;
        for(int i = 0; i < n-2; i++){
            for(int j = 0; j < m-2; j++){
                if(a[i][j] != b[i][j]){
                    for(int x = i; x < i+3; x++){
                        for(int y = j; y < j+3; y++){
                            a[x][y] = a[x][y] ^ 1;
                        }
                    }
                    result++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != b[i][j]){
                    bw.write(-1+"");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
