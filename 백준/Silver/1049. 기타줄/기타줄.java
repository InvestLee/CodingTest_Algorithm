import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int minSix = 1000 *  6 + 1;
        int minOne = 1000 + 1;
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            minSix = Math.min(minSix,Integer.parseInt(st.nextToken()));
            minOne = Math.min(minOne,Integer.parseInt(st.nextToken()));
        }
        int divideSix = n / 6;
        int remainSix = n % 6;
        if(minOne * 6 < minSix) bw.write(n * minOne+"");
        else if(remainSix * minOne >= minSix) bw.write(divideSix * minSix + minSix+"");
        else bw.write(divideSix * minSix + remainSix * minOne+"");
        bw.flush();
        bw.close();
    }
}
