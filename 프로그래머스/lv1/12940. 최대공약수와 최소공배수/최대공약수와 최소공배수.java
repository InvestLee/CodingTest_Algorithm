class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {0,0};
        int big = 0;
        int small = 0;
        if (n > m){
            big = n;
            small = m;
        } else {
            big = m;
            small = n;
        }
        int temp = 0;
        while (true) {
            temp = big;
            big = small;
            small = temp%small;
            if (small == 0){
                answer[0] = big;
                answer[1] = (n*m)/big;
                break;
            }
        }
        return answer;
    }
}