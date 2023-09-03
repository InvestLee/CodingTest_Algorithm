import java.io.*;
import java.util.*;

//백준 2346 풍선 터뜨리기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<int[]> balloons = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            balloons.add(new int[]{i,Integer.parseInt(st.nextToken())});
        }

        int[] ball;
        while(balloons.size() > 1){
            ball = balloons.pollFirst();
            bw.write(ball[0]+" ");
            if(ball[1] > 0){
                for(int j = 1; j < ball[1]; j++){
                    balloons.addLast(balloons.pollFirst());
                }
            } else {
                for(int j = ball[1]; j < 0; j++) {
                    balloons.addFirst(balloons.pollLast());
                }
            }
        }
        bw.write(balloons.pollFirst()[0]+" ");
        bw.flush();
        br.close();
        bw.close();
    }
}