import java.io.*;

//백준 14470 전자레인지
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int result;
        if(a < 0){
            result = c*(-a)+d+e*b;
        } else {
            result = e*(b-a);
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}