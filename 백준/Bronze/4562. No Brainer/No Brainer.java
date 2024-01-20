import java.io.*;
import java.util.StringTokenizer;

//4562 No Brainer
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int x, y;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if(x >= y) bw.write("MMM BRAINS\n");
            else bw.write("NO BRAINS\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}