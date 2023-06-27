import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> arr = new ArrayList<>();
        arr.add(new BigInteger("0"));
        arr.add(new BigInteger("1"));
        for(int i = 2; i <=n; i++) arr.add(arr.get(i-2).add(arr.get(i-1)));
        bw.write(String.valueOf(arr.get(n)));
        bw.flush();
        bw.close();
    }
}
