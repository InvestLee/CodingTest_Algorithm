import java.io.*;
import java.util.StringTokenizer;

//백준 1551 수열의 변화
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] temp = br.readLine().split(",");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(temp[i]);
        }

        for(int i = 1; i <= k; i++){
            for(int j = n-1; j >= i; j--){
                arr[j] -= arr[j-1];
            }
        }

        for(int i = k; i < n-1; i++){
            bw.write(arr[i]+",");
        }
        bw.write(arr[n-1]+"");

        bw.flush();
        br.close();
        bw.close();
    }
}