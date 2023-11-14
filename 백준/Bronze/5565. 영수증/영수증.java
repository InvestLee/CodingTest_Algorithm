import java.io.*;

//백준 5565 영수증
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = Integer.parseInt(br.readLine());

        for(int i = 0; i < 9; i++){
            result -= Integer.parseInt(br.readLine());
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}