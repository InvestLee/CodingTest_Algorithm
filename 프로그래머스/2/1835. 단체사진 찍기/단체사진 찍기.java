class Solution {
    public static char[] friends;
    public static boolean[] visited;
    public static int answer;
    public static String[] condition;
    
    public int solution(int n, String[] data) {
        answer = 0;
        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited = new boolean[8];
        condition = data;
        dfs("",0);
        return answer;
    }
    
    public static void dfs(String line, int depth){
        if(depth == 8){
            if(isOk(line)) answer++;
            return;
        }
        
        for(int i = 0; i < 8; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(line + friends[i], depth+1);
                visited[i] = false;
            }
        }
    } 
    
    public static boolean isOk(String line){
        int dist, val;
        char sign;
        for(String c : condition){
            dist = Math.abs(line.indexOf(c.charAt(0)) 
                            - line.indexOf(c.charAt(2)))-1;
            sign = c.charAt(3);
            val = c.charAt(4) - '0';
            if(sign  == '='){
                if (dist != val) return false;
            } else if(sign == '>'){
                if (dist <= val) return false;
            } else {
                if (dist >= val) return false;
            }
        }
        
        return true;
    } 
}