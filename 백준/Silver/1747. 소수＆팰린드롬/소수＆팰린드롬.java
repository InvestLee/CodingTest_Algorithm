import java.io.*;

//백준 1747 소수&팰린드롬
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n==1) bw.write(2+"");
        else{
            while(true){
                if(isPrime(n) && isPalindrome(n)){
                    bw.write(n+"");
                    break;
                }
                n++;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int num){
        String target = Integer.toString(num);
        int cnt = target.length();
        for(int i = 0; i <= cnt / 2; i++){
            if(target.charAt(i) != target.charAt(cnt-i-1)) return false;
        }
        return true;
    }
}