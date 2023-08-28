import java.io.*;
import java.util.*;

//백준 2342 Dance Dance Revolution
public class Main {

    public static int[] move;
    public static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] command = br.readLine().split(" ");
        move = new int[command.length-1];
        for(int i = 0; i < command.length-1; i++) move[i] = Integer.parseInt(command[i]);
        dp = new int[5][5][command.length];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        bw.write(cal(0,0,0)+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int cal(int leftFoot, int rightFoot, int cnt){
        if(cnt == move.length) return 0;
        if(dp[leftFoot][rightFoot][cnt] != -1) return dp[leftFoot][rightFoot][cnt];
        dp[leftFoot][rightFoot][cnt] =
                Math.min(cal(move[cnt],rightFoot,cnt+1) + cost(leftFoot, move[cnt]),
                        cal(leftFoot,move[cnt],cnt+1) + cost(rightFoot, move[cnt]));
        return dp[leftFoot][rightFoot][cnt];
    }

    public static int cost(int now, int next){
        int dist = Math.abs(now - next);
        if(now == 0) return 2;
        if(dist == 0) return 1;
        if(dist == 1 || dist == 3) return 3;
        return 4;
    }
}