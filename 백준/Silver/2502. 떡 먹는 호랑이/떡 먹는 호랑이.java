import java.io.*;
import java.util.*;

//2502 떡 먹는 호랑이
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int x, y, temp, size;
        if(d == 3) bw.write(1+"\n"+(k-1));
        else{
            x = 1;
            y = 1;
            for(int i = 4; i <= d; i++){
                temp = y;
                y = x + y;
                x = temp;
            }
            size = k/y;
            for(int i = size - 1; i >= 0; i--){
                if((k-(i*y))%x == 0){
                    bw.write((k-(i*y))/x+"\n"+i);
                    break;
                }
            }
        }
        bw.flush();
    }
}
