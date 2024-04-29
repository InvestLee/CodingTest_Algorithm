class Solution {
    public int solution(String s) {
        int answer = 0;
        int cntA = 0;
        int cntB = 0;
        char x = ' ';
        char temp = ' ';
        for(int i = 0; i < s.length(); i++){
            temp = s.charAt(i);
            if(cntA == 0){
                x = temp;
                cntA++;
            } else if(x == temp){
                cntA++;
            } else {
                cntB++;
            }
            if(cntA == cntB){
                cntA = 0;
                cntB = 0;
                answer++;
            }
        }
        if(cntA > 0) answer++;
        return answer;
    }
}