class Solution {
    public String solution(int age) {
        String answer = "";
        for(int i = 0; i < (""+age).length(); i++) answer += (char)((""+age).charAt(i)+'a'-'0');
        return answer;
    }
}