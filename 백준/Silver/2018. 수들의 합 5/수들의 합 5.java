import java.io.*;

//백준 2018 수들의 합 5
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int start = 1;
        int end = 1;
        int sum = 1;

        while(start <= end){
            if(sum == n) result++;
            if(sum < n){
                end++;
                sum += end;
            } else{
                sum -= start;
                start++;
            }
        }
        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}