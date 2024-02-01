import java.io.*;

//10707 수도요금
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        int x = a * p;
        int y;
        if(p > c) y = b + (p - c) * d;
        else y = b;

        bw.write(Math.min(x,y)+ "");
        bw.flush();
        bw.close();
        br.close();
    }
}