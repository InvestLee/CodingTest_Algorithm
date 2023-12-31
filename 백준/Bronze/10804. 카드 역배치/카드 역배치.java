import java.io.*;
import java.util.*;

//10804 카드 역배치
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] card = new int[21];
        for(int i = 1; i <= 20; i++) card[i] = i;

        StringTokenizer st;
        int start, end, temp;
        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            for(int j = start; j <= (start+end) / 2; j++){
                temp = card[j];
                card[j] = card[end+start-j];
                card[end+start-j] = temp;
            }
        }

        for(int i = 1; i <= 20; i++) bw.write(card[i]+" ");
        bw.flush();
        bw.close();
        br.close();
    }
}