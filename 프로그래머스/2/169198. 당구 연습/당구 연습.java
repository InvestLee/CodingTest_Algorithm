class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int temp;
        for(int i = 0; i < balls.length; i++){
            answer[i] = Integer.MAX_VALUE;
            if(!(startX == balls[i][0] && startY <= balls[i][1])){
                temp = (int) (Math.pow(startX - balls[i][0], 2) 
                                 + Math.pow(startY + balls[i][1] - 2*n, 2));
                answer[i] = Math.min(answer[i], temp);
            }
            
            if(!(startX == balls[i][0] && startY >= balls[i][1])){
                temp = (int) (Math.pow(startX - balls[i][0], 2) 
                                      + Math.pow(startY + balls[i][1], 2));
                answer[i] = Math.min(answer[i], temp);
            }
            
            if(!(startX >= balls[i][0] && startY == balls[i][1])){
                temp = (int) (Math.pow(startX + balls[i][0], 2) 
                                      + Math.pow(startY - balls[i][1], 2));
                answer[i] = Math.min(answer[i], temp);
            }
            
            if(!(startX <= balls[i][0] && startY == balls[i][1])){
                temp = (int) (Math.pow(startX + balls[i][0] - 2*m, 2) 
                                 + Math.pow(startY - balls[i][1], 2));
                answer[i] = Math.min(answer[i], temp);
            }
        }
        return answer;
    }
}
