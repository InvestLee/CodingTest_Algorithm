import java.util.*;

class Solution {
    public int answer = 0;
    public ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    
    public int solution(int n, int[][] lighthouse) {
        for(int i = 0; i <= n; i++){
            tree.add(new ArrayList<>());
        }
        for(int i = 0; i < lighthouse.length; i++){
            tree.get(lighthouse[i][0]).add(lighthouse[i][1]);
            tree.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        dfs(1,0);
        return answer;
    }
    
    public int dfs(int cur, int prev){
        if(tree.get(cur).size() == 1 && tree.get(cur).get(0) == prev){
            return 1;
        }
        
        int leafCnt = 0;
        for(int next : tree.get(cur)){
            if(next == prev) continue;
            leafCnt += dfs(next, cur);
        }
        
        if(leafCnt == 0) return 1;
        
        answer++;
        return 0;
    }
}