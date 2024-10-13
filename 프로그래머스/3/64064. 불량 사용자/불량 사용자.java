import java.util.*;

class Solution {
    public static boolean[] visited;
    public static int userLen, banLen;
    public static HashSet<String> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        userLen = user_id.length;
        banLen = banned_id.length;
        visited = new boolean[userLen];
        set = new HashSet<>();
        for(int i = 0; i < banLen; i++){
            banned_id[i] = banned_id[i].replace("*",".");
        }
        dfs(0, user_id, banned_id, "");
        return set.size();
    }
    
    public static void dfs(
        int depth, 
        String[] user_id, 
        String[] banned_id,
        String pr
    ){
        if(depth == banLen){
            String[] temp = pr.split(" ");
            Arrays.sort(temp);
            String node = "";
            for(int i = 0; i < temp.length; i++){
                node += temp[i];
            }
            set.add(node);
            return;
        }
        
        for(int i = 0; i < userLen; i++){
            if(!visited[i] && user_id[i].matches(banned_id[depth])){
                visited[i] = true;
                dfs(depth+1, user_id, banned_id, pr+" "+user_id[i]);
                visited[i] = false;
            }
        }
    }
}