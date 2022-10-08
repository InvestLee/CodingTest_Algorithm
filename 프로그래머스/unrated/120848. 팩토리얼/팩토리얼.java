class Solution {
    public int solution(int n) {
        if (n == 1) return 1;
        int answer = 0;
        while (n > 1){
            answer++;
            n /= answer;
        }
        if (n == 1) return answer;
        else return answer-1;
    }
}