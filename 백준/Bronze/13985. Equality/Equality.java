import java.io.*;
import java.util.StringTokenizer;

//13985 Equality
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        String temp = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        temp = st.nextToken();
        int c = Integer.parseInt(st.nextToken());

        if((a+b) == c) bw.write("YES");
        else bw.write("NO");

        bw.flush();
        bw.close();
        br.close();
    }
}