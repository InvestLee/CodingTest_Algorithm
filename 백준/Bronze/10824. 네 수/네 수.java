import java.io.*;
import java.util.*;

//백준 10824 네 수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String ab = st.nextToken()+st.nextToken();
        String cd = st.nextToken()+st.nextToken();

        long result = Long.parseLong(ab) + Long.parseLong(cd);

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}