import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] sticks = new int[n];
        for(int i = 0; i < n; i++) sticks[i] = Integer.parseInt(br.readLine());

        int result = 0;
        int longestStick = 0;
        for(int i = n-1; i >= 0; i--){
            if(longestStick < sticks[i]){
                longestStick = sticks[i];
                result++;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
