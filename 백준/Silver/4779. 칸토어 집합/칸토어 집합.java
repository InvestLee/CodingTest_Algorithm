import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int n;
    public static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cantor;
        while((cantor = br.readLine()) != null){
            n = Integer.parseInt(cantor);
            result = new StringBuilder();
            int len = (int) Math.pow(3,n);
            for (int i = 0; i < len; i++) result.append("-");
            divideConquer(0,len);
            System.out.println(result);
        }
    }

    public static void divideConquer(int idx, int len){
        if(len == 1) return;
        int nextLen = len/3;
        for (int i = idx+nextLen; i < idx+2*nextLen; i++) result.setCharAt(i,' ');
        divideConquer(idx, nextLen);
        divideConquer(idx+2*nextLen, nextLen);
    }
}
