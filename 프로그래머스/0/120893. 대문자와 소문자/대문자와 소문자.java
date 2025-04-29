class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i++){
            char cur = my_string.charAt(i);
            if(cur > 'Z') answer += (char)(cur - 32);
            if(cur < 'a') answer += (char)(cur + 32);
        }
        return answer;
    }
}