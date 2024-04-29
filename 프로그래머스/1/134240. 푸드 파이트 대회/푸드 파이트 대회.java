class Solution {
    public String solution(int[] food) {
        String answer = "";
        String reverse = "";
        
        int temp;
        for(int i = 1; i < food.length; i++){
            temp = food[i] / 2;
            for(int j = 0; j < temp; j++){
                answer = answer + String.valueOf(i);
                reverse = String.valueOf(i) + reverse;
            }
        }
        
        answer = answer + "0" + reverse;
        return answer;
    }
}