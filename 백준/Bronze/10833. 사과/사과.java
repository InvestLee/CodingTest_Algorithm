import java.io.*;
import java.util.StringTokenizer;

//10833 사과
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int student, apple;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            student = Integer.parseInt(st.nextToken());
            apple = Integer.parseInt(st.nextToken());
            result += apple % student;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}