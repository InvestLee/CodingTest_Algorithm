import java.io.*;

//14490 백대열
public class Main {
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] splitList = br.readLine().split(":");
        n = Integer.parseInt(splitList[0]);
        m = Integer.parseInt(splitList[1]);

        int cal = gcd(Math.max(n,m), Math.min(n,m));
        sb.append(n/cal).append(":").append(m/cal);
        System.out.println(sb);
    }

    public static int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
}