import java.io.*;
import java.util.*;

//백준 3495 아스키 도형
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int h, w;
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        char[][] arr = new char[h][w];
        String temp;
        double result = 0;
        int cnt = 0;
        for(int i = 0; i < h; i++){
            temp = br.readLine();
            for(int j = 0; j < w; j++){
                arr[i][j] = temp.charAt(j);
                if(arr[i][j] == '/' || arr[i][j] == '\\'){
                    result += 0.5;
                    cnt++;
                } else if(cnt % 2 == 1 && arr[i][j] == '.'){
                    result++;
                }
            }
        }

        bw.write((int)result+"");
        bw.flush();
        bw.close();
    }
}
