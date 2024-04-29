class Solution {
    public int solution(int number, int limit, int power) {
        int[] ap = new int[number+1];
        for(int i = 1; i <= number; i++){
            for(int j = 1; j * j <= i; j++){
                if(j * j == i) ap[i]++;
                else if(i % j == 0) ap[i] += 2;
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= number; i++){
            if(ap[i] > limit) answer += power;
            else answer += ap[i];
        }
        
        return answer;
    }
}