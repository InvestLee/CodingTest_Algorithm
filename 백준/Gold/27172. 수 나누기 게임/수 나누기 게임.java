import java.io.*;
import java.util.*;

//백준 27172 수 나누기 게임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] players = new int[n];
        int maxValue = 0;
        for(int i = 0; i < n; i++){
            players[i] = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, players[i]);
        }
        int[] scores = new int[maxValue+1];
        boolean[] cards = new boolean[maxValue+1];
        for(int player : players){
            cards[player] = true;
        }

        for(int player : players){
            for(int i = player * 2; i <= maxValue; i += player){
                if(cards[i]){
                    scores[player]++;
                    scores[i]--;
                }
            }
        }

        for(int player : players) bw.write(scores[player]+" ");

        bw.flush();
        br.close();
        bw.close();
    }
}