import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int aver = 0;
        for (int i = 0; i < 5; i++){
            arr[i] = Integer.parseInt(br.readLine());
            aver += arr[i];
        }
        br.close();
        aver /= 5;
        Arrays.sort(arr);
        System.out.println(aver);
        System.out.println(arr[2]);
    }
}