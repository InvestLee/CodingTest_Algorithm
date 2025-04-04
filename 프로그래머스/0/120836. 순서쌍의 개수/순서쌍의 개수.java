class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= Math.sqrt(n); i++) if(n % i == 0) answer += 2;
        return Math.round(Math.sqrt(n)) == Math.sqrt(n) ? answer-1 : answer;
    }
}