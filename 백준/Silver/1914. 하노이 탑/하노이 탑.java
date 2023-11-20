import java.io.*;
import java.math.BigInteger;

//백준 1914 하노이 탑
public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger num = new BigInteger("2");
        bw.write(num.pow(n).subtract(new BigInteger("1"))+"\n");
        if(n <= 20){
            hanoi(n,1,3);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void hanoi(int n, int start, int end) throws IOException {
        if(n == 0) return;
        hanoi(n-1, start, 6 - start - end);
        bw.write(start+" ");
        bw.write(end+"\n");
        hanoi(n-1, 6 - start - end, end);
    }
}