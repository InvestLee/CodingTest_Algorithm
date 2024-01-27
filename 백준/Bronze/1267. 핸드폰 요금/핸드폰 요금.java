import java.io.*;
import java.util.StringTokenizer;

//1267 핸드폰 요금
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int yCost = 0;
        int mCost = 0;

        int temp;
        for(int i = 0; i < n; i++){
            temp = Integer.parseInt(st.nextToken());
            yCost += 10 * ((temp / 30) + 1);
            mCost += 15 * ((temp / 60) + 1);
        }

        if(yCost == mCost) bw.write("Y M "+yCost);
        else if(yCost < mCost) bw.write("Y "+yCost);
        else bw.write("M "+mCost);

        bw.flush();
        bw.close();
        br.close();
    }
}