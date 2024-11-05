import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        long[] longA = new long[a.length];
        for(int i = 0; i < a.length; i++){
            answer += a[i];
            longA[i] = a[i];
        }
        if(answer != 0) return -1;
        if(a.length==2) return Math.abs(a[0]);
        
        ArrayList<Integer>[] tree = new ArrayList[a.length];
        boolean[] visited = new boolean[a.length];
        int[] indegree = new int[a.length];
        for(int i = 0; i < a.length; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < a.length; i++){
            if(tree[i].size()==1) q.add(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            long temp = longA[cur];
            for(int i = 0; i < tree[cur].size(); i++){
                int next = tree[cur].get(i);
                if(!visited[next]){
                    --indegree[next];
                    longA[next] += temp;
                    longA[cur] = 0;
                    answer += Math.abs(temp);
                    if(indegree[next] == 1){
                        q.add(tree[cur].get(i));
                    }
                    break;
                }
            }
        }
        return answer;
    }
}