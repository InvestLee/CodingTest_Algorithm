import java.io.*;
import java.util.*;

//백준 1766 문제집
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] problems = new ArrayList[n+1];
        int[] haveCondition = new int[n+1];
        for(int i = 1; i <= n; i++){
            problems[i] = new ArrayList<>();
        }
        int pre, post;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            pre = Integer.parseInt(st.nextToken());
            post = Integer.parseInt(st.nextToken());
            problems[pre].add(post);
            haveCondition[post]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++){
            if(haveCondition[i] == 0) pq.add(i);
        }
        int now;
        while(!pq.isEmpty()){
            now = pq.poll();
            bw.write(now+" ");
            for(int next : problems[now]){
                haveCondition[next]--;
                if(haveCondition[next] == 0) pq.add(next);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}