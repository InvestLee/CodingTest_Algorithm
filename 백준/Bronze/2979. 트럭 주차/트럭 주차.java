import java.io.*;
import java.util.StringTokenizer;

//2979 트럭 주차
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] time = new int[101];

        int start, end;
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            for(int j = start + 1; j <= end; j++){
                time[j]++;
            }
        }

        int result = 0;
        for(int i = 1; i < 101; i++){
            if(time[i] == 1) result += a;
            else if(time[i] == 2) result += 2*b;
            else if(time[i] == 3) result += 3*c;
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}