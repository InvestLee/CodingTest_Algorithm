class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int AttIdx = 0;
        int healCnt = 0;
        int fin = attacks[attacks.length-1][0];
        for(int i = 1; i <= fin; i++){
            healCnt++;
            if(i == attacks[AttIdx][0]){
                answer -= attacks[AttIdx][1];
                AttIdx++;
                healCnt = 0;
                if(answer <= 0){
                    answer = -1;
                    break;
                }
                continue;
            }
            
            if(answer + bandage[1] > health) answer = health;
            else answer += bandage[1];
            
            if(healCnt == bandage[0]){
                if(answer + bandage[2] > health) answer = health;
                else answer += bandage[2];
                healCnt = 0;
            }
        }
        return answer;
    }
}