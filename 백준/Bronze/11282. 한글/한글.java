import java.io.*;

//11282 한글
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()) + 44031;
        bw.write((char) n);
        bw.flush();
        bw.close();
        br.close();
    }
}