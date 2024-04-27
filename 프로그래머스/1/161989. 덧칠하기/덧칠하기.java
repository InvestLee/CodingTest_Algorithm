class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int temp = 0;
        for(int i : section){
            if(temp < i){
                temp = i + m - 1;
                answer++;
            }
        }
        return answer;
    }
}