import java.io.*;
import java.util.*;

//2002 추월
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            hashMap.put(br.readLine(), i);
        }
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = hashMap.get(br.readLine());
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] > arr[j]){
                    result++;
                    break;
                }
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}