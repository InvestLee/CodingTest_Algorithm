import java.io.*;
import java.util.*;

//1225 이상한 곱셈
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        long result = 0;
        int num1, num2;
        for(int i = 0; i < a.length(); i++){
            for(int j = 0; j < b.length(); j++){
                num1 = a.charAt(i) - '0';
                num2 = b.charAt(j) - '0';
                result += num1 * num2;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}