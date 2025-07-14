class Solution {
    public int solution(int order) {
        int answer = 0;
        for(int i = 0; i < (""+order).length(); i++) if(((""+order).charAt(i) - '0') != 0 && ((""+order).charAt(i) - '0') % 3 == 0) answer++;
        return answer;
    }
}