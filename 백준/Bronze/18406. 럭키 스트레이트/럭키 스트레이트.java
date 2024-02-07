import java.io.*;

//18406 럭키 스트레이트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        int len = n.length();
        int resultA = 0;
        int resultB = 0;

        for(int i = 0; i < len / 2; i++){
            resultA += n.charAt(i) - '0';
        }

        for(int i = len / 2; i < len; i++){
            resultB += n.charAt(i) - '0';
        }

        if(resultA == resultB) bw.write("LUCKY");
        else bw.write("READY");
        bw.flush();
        bw.close();
        br.close();
    }
}