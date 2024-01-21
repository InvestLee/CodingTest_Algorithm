import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        
        HashSet<Character> dic = new HashSet<>();
        for(int i = 0; i < skip.length(); i++){
            dic.add(skip.charAt(i));
        }
        
        String answer = "";
        char temp;
        int cnt;
        for(int i = 0; i < s.length(); i++){
            cnt = index;
            temp = s.charAt(i);
            while(cnt > 0){
                temp++;
                if(!dic.contains(temp)) cnt--;
                if(temp > 'z'){
                    temp = 'a';
                    while(dic.contains(temp)) temp++;
                }
            }
            answer += temp;
        }
        
        return answer;
    }
}