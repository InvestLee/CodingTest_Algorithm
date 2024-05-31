import java.io.*;

//17427 약수의 합 2
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long result = 0;

        for(int i = 1; i <= n; i++){
            result += i * (n/i);
        }
        bw.write(result+"");
        bw.flush();
    }
}