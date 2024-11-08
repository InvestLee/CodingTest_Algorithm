import java.util.*;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);
        int sameLen = calLen(words[0], words[1]);
        if(sameLen < words[0].length()) answer += sameLen + 1;
        else answer += sameLen;
        
        for(int i = 1; i < words.length - 1; i++){
            sameLen = calLen(words[i], words[i-1]);
            sameLen = Math.max(sameLen, calLen(words[i], words[i+1]));
            if(sameLen < words[i].length()) answer += sameLen + 1;
            else answer += sameLen;
        }
        
        sameLen = calLen(words[words.length-2], words[words.length-1]);
        if(sameLen < words[words.length-1].length()) answer += sameLen + 1;
        else answer += sameLen;
        
        return answer;
    }
    
    public static int calLen(String s1, String s2){
        int length = 0;
        int min = Math.min(s1.length(), s2.length());
        for(int i = 0; i < min; i++){
            if(s1.charAt(i) == s2.charAt(i)) length++;
            else break;
        }
        return length;
    }
}