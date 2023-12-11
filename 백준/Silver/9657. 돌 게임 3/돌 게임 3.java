import java.io.*;

//9657 돌 게임 3
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        bw.write((n % 7 == 0 || n % 7 == 2) ? "CY" : "SK");
        bw.flush();
        bw.close();
        br.close();
    }
}