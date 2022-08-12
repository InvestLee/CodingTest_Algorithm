class Solution {
    public String solution(String s) {
        String[] s_list = s.split("");
        String answer = "";
        int count = 0;
        for(String ss:s_list){
            answer += count % 2 == 0 ? ss.toUpperCase() : ss.toLowerCase();
            if (ss.contains(" ")) count = 0;
            else count += 1;
        }
        return answer;
    }
}