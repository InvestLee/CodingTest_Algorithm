import java.io.*;
import java.util.*;

//10994 별 찍기 19
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int len = 4 * n - 3;
        char[][] arr = new char[len][len];
        int idx = 0;

        for(int i = 1; i <= n; i++){
            for(int j = idx; j < len - idx; j++){
                arr[idx][j] = '*';
                arr[len-idx-1][j] = '*';
                arr[j][idx] = '*';
                arr[j][len-idx-1] = '*';
            }
            idx += 2;
        }

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(arr[i][j] == '*') bw.write("*");
                else bw.write(" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}