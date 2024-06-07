import java.io.*;
import java.util.*;

//1052 물병
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;
        int index = -1;
        String bitN = Integer.toBinaryString(n);
        int ones = Integer.bitCount(n);
        if(ones > k){
            for (int i = 0; i < bitN.length(); i++) {
                if (k == 0) {
                    index = i;
                    break;
                }
                if (bitN.charAt(i) == '1')
                    k--;
            }
            String temp = bitN.substring(index);
            int t = Integer.parseInt(temp, 2);
            if (t != 0)
                result = (int) (Math.pow(2, bitN.length() - index) - t);
        }
        bw.write(result + "");
        bw.flush();
    }
}