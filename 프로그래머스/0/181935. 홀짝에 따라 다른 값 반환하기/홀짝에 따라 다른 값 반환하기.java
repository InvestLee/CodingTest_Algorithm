class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = n%2; i <= n; i += 2) answer += Math.pow(i,2-n%2);
        return answer;
    }
}