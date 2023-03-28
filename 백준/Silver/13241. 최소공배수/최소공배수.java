import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long big, small, temp;
        if (a>b){
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }

        while(true){
            temp = small;
            small = big%small;
            big = temp;
            if(small == 0){
                System.out.println(a*b/big);
                break;
            }
        }
    }
}