import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i = 0; i < s.length; i++){
            Stack<Character> stack = new Stack<>();
            int cnt = 0;
            for(int j = 0; j < s[i].length(); j++){
                stack.push(s[i].charAt(j));
                if(stack.size() >= 3){
                    char first = stack.pop();
                    if(first != '0'){
                        stack.push(first);
                        continue;
                    }
                    char second = stack.pop();
                    if(second != '1'){
                        stack.push(second);
                        stack.push(first);
                        continue;
                    }
                    char third = stack.pop();
                    if(third != '1'){
                        stack.push(third);
                        stack.push(second);
                        stack.push(first);
                        continue;
                    }
                    cnt++;
                }
            }
            StringBuilder sb = new StringBuilder();
            int idx = stack.size();
            while(!stack.isEmpty()){
                char c = stack.pop();
                sb.insert(0, c);
                if(c == '0') break;
                else idx--;
            }
            while(!stack.isEmpty()){
                sb.insert(0, stack.pop());
            }
            for(int j = 0; j < cnt; j++) sb.insert(idx, "110");
            answer[i] = sb.toString();
        }
        return answer;
    }
}