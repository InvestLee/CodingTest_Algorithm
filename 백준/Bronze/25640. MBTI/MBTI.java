import java.io.*;

//25640 MBTI
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        String jinHo = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String other;
        while(n-- > 0){
            other = br.readLine();
            if(jinHo.equals(other)) result++;
        }
        bw.write(result+"");
        bw.flush();
    }
}
