import java.util.*;

class Solution {
    
    public static boolean[] visited;
    public static ArrayList<Integer>[] map;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        map = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            map[i] = new ArrayList<>();
        }
        for(int[] r : roads){
            map[r[0]].add(r[1]);
            map[r[1]].add(r[0]);
        }
        
        for(int i = 0; i < sources.length; i++){
            if(sources[i] == destination){
                answer[i] = 0;
                continue;
            }
            visited = new boolean[n+1];
            answer[i] = bfs(sources[i], destination);
        }
        
        return answer;
    }
    
    public static int bfs(int cur, int destination){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cur,0});
        visited[cur] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int m : map[now[0]]){
                if(m == destination) return now[1] + 1;
                else if(!visited[m]){
                    visited[m] = true;
                    q.offer(new int[]{m, now[1]+1});
                }
            }
        }
        return -1;
    }
}