import java.io.*;

//백준 2023 신기한 소수
public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        getResult(0,n);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void getResult(int cur, int n) throws IOException{
        if(n == 0){
            if(isPrime(cur)) bw.write(cur+"\n");
            return;
        }
        int next;
        for(int i = 0; i < 10; i++){
            next = cur * 10 + i;
            if(isPrime(next)) getResult(next, n-1);
        }
    }

    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}