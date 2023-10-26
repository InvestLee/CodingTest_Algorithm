import java.io.*;

//백준 2847 게임을 만든 동준이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] levels = new int[n];
        for(int i = 0; i < n; i++) levels[i] = Integer.parseInt(br.readLine());

        int result = 0;
        for(int i = n-1; i > 0; i--){
            if(levels[i] > levels[i-1]) continue;
            result += (levels[i-1] - levels[i] + 1);
            levels[i-1] = levels[i] - 1;
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}