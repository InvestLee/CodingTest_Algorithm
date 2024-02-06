import java.io.*;

//10821 정수의 개수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] num = br.readLine().split(",");

        bw.write(num.length+"");
        bw.flush();
        bw.close();
        br.close();
    }
}