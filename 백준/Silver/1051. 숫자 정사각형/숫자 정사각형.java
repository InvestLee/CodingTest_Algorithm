import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        String temp;
        for(int i = 0; i < n; i++){
            temp = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = temp.charAt(j)-'0';
            }
        }

        int result = 1;
        int squareLength = Math.min(n,m);
        while(squareLength-- > 0){
            if(square(squareLength)){
                result = (squareLength+1)*(squareLength+1);
                break;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static boolean square(int a){
        for(int i = 0; i + a < n; i++){
            for(int j = 0; j + a < m; j++){
                if(arr[i][j] == arr[i+a][j] && arr[i+a][j] == arr[i][j+a] && arr[i][j+a] == arr[i+a][j+a]){
                    return true;
                }
            }
        }
        return false;
    }
}
