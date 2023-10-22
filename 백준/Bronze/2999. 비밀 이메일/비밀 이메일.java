import java.io.*;
import java.util.*;

//백준 2999 비밀 이메일
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String message = br.readLine();
        int r = 1;
        int c = message.length();
        for(int i = 1; i <= Math.sqrt(message.length()); i++){
            if(message.length() % i == 0){
                r = i;
                c = message.length() / i;
            }
        }

        char[][] arr = new char[r][c];

        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                arr[j][i] = message.charAt(r*i+j);
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                bw.write(arr[i][j]+"");
            }
        }


        bw.flush();
        br.close();
        bw.close();
    }
}