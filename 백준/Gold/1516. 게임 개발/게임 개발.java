import java.io.*;
import java.util.*;

//백준 1516 게임 개발
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] requireTime = new int[n+1];
        int[] precede = new int[n+1];
        int[] result = new int[n+1];
        ArrayList<ArrayList<Integer>> info = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            info.add(new ArrayList<>());
        }

        int temp;
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            requireTime[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                temp = Integer.parseInt(st.nextToken());
                if(temp == -1) break;
                info.get(temp).add(i);
                precede[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(precede[i] == 0) q.offer(i);
        }

        int cur, next;
        while(!q.isEmpty()){
            cur = q.poll();
            result[cur] += requireTime[cur];
            for(int i = 0; i < info.get(cur).size(); i++){
                next = info.get(cur).get(i);
                precede[next]--;
                if(precede[next] == 0) q.offer(next);
                result[next] = Math.max(result[next], result[cur]);
            }
        }

        for(int i = 1; i <= n; i++) bw.write(result[i]+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}