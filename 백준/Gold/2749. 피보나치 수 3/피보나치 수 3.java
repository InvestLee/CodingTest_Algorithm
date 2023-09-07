import java.io.*;

//백준 2749 피보나치 수 3
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int pisano = 1500000;
        long n = Long.parseLong(br.readLine()) % pisano;
        long[] pibo = new long[pisano + 1];
        pibo[0] = 0;
        pibo[1] = 1;

        for(int i = 2; i <= pisano; i++){
            pibo[i] = (pibo[i-1] + pibo[i-2]) % 1000000;
        }
        bw.write(pibo[(int)n]+"");
        bw.flush();
        br.close();
        bw.close();
    }
}