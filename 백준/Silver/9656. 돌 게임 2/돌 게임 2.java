import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String result;
        if(n % 2 == 0 ) result = "SK";
        else result = "CY";

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
