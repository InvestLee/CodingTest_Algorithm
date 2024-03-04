import java.io.*;
import java.util.*;

//1758 알바생 강호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Comparator.reverseOrder());

        long result = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] - i <= 0){
                break;
            }
            result += arr[i] - i;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}