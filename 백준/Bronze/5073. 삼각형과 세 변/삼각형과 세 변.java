import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] triangle = new int[3];
        while(true){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 3; i++) triangle[i] = Integer.parseInt(st.nextToken());
            if(triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) break;
            Arrays.sort(triangle);
            if(triangle[0] + triangle[1] <= triangle[2]) System.out.println("Invalid");
            else if(triangle[0] == triangle[1] && triangle[1] == triangle[2]) System.out.println("Equilateral");
            else if(triangle[0] == triangle[1] || triangle[1] == triangle[2] || triangle[0] == triangle[2]) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
    }

}