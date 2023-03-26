import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        int[] triangle = new int[3];
        for(int i = 0; i < 3; i++) triangle[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(triangle);
        if(triangle[0] + triangle[1] <= triangle[2]) System.out.println(2*(triangle[0] + triangle[1])-1);
        else System.out.println(triangle[0] + triangle[1] + triangle[2]);
    }
}