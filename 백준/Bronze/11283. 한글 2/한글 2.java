import java.io.*;

//백준 11283 한글 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char c = br.readLine().charAt(0);

        bw.write(((int)c - 44031)+"");
        bw.flush();
        br.close();
        bw.close();
    }
}