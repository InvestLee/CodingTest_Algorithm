class Solution {
    public int solution(int storey) {
        int answer = 0;
        int remain;
        while(storey > 0){
            remain = storey % 10;
            storey = storey / 10;
            if(remain == 5){
                if(storey % 10 >= 5){
                    answer += 10 - remain;
                    storey++;
                } else {
                    answer += remain;
                }
            } else if(remain > 5){
                answer += 10 - remain;
                storey++;
            } else {
                answer += remain;
            }
        }
        
        return answer;
    }
}