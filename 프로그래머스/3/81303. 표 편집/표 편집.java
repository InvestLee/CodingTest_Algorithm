import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> delete = new Stack<>();
        for(int i = 0; i < cmd.length; i++){
            char c = cmd[i].charAt(0);
            if(c == 'U'){
                k -= Integer.parseInt(cmd[i].substring(2));
            }
            else if(c == 'D'){
                k += Integer.parseInt(cmd[i].substring(2));
            }
            else if(c == 'C'){
                delete.add(k);
                n--;
                if(n == k) k--;
            }
            else if(c == 'Z'){
                if(delete.pop() <= k) k++;
                n++;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++){
            answer.append("O");
        }
        while(!delete.isEmpty()){
            answer.insert(delete.pop(), "X");
        }
        return answer.toString();
    }
}