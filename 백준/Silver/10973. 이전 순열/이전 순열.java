import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        if(!nextPermutation(arr)) bw.write("-1");
        else for(int i = 0; i < n; i++) bw.write(arr[i]+" ");
        bw.flush();
        bw.close();
    }

    public static boolean nextPermutation(int[] arr){
        int i = arr.length-1;
        while(i > 0 && arr[i-1] <= arr[i]) i--;
        if(i <= 0) return false;

        int j = arr.length-1;
        while(arr[j] >= arr[i-1]) j--;

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length-1;
        while(i < j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
