import java.util.*;

class Solution {
    public static boolean[] visited;
    public static ArrayList<String> arr;
        
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        arr = new ArrayList<>();
        dfs(0, tickets, "ICN", "ICN");
        Collections.sort(arr);
        String[] answer = {};
        return arr.get(0).split(" ");
    }
    
    public static void dfs(
        int depth, 
        String[][] tickets,
        String res,
        String cur
    ){
        if(depth == tickets.length){
            arr.add(res);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && cur.equals(tickets[i][0])){
                visited[i] = true;
                dfs(depth+1, tickets, res+" "+tickets[i][1], tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}