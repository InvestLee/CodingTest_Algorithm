import java.io.*;
import java.util.StringTokenizer;

//10093 숫자
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long temp;
        if(a > b){
            temp = a;
            a = b;
            b = temp;
        }
        long result = b - a - 1;
        if(a == b) bw.write("0");
        else{
            bw.write(result+"\n");
            for(long i = a + 1; i < b; i++) bw.write(i+" ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}