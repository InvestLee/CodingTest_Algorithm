import java.io.*;
import java.util.*;

//백준 1525 퍼즐
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String num = "";
        int temp;
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                temp = Integer.parseInt(st.nextToken());
                if(temp == 0) temp = 9;
                num += temp;
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put(num,0);
        Queue<String> q = new LinkedList<>();
        q.offer(num);

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        String now, next;
        int blankIdx, x, y, nx, ny, move;
        char tempChar;
        StringBuilder sb;
        while(!q.isEmpty()){
            now = q.poll();
            blankIdx = now.indexOf("9");
            x = blankIdx % 3;
            y = blankIdx / 3;
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                move = ny * 3 + nx;
                if(nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;
                sb = new StringBuilder(now);
                tempChar = sb.charAt(move);
                sb.setCharAt(move,'9');
                sb.setCharAt(blankIdx,tempChar);
                next = sb.toString();
                if(!map.containsKey(next)){
                    map.put(next, map.get(now)+1);
                    q.offer(next);
                }
            }
        }
        if(map.containsKey("123456789")) bw.write(map.get("123456789")+"");
        else bw.write("-1");
        bw.flush();
        br.close();
        bw.close();
    }
}