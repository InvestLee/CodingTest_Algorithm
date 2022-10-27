import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int x = 1;
        int y = 1;
        for (int i = 1; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++){
                int num = Integer.parseInt(st.nextToken());
                if (result < num){
                    result = num;
                    x = i;
                    y = j;
                }
            }
        }
        br.close();
        System.out.println(result);
        System.out.printf("%d %d",x,y);
    }
}