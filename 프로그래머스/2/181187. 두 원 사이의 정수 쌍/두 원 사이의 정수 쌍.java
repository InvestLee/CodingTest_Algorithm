class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long distR1, distR2;
        for(int i = 1; i <= r2; i++){
            distR2 = (long)Math.floor(Math.sqrt(1.0*r2*r2 - 1.0*i*i));
            distR1 = (long)Math.ceil(Math.sqrt(1.0*r1*r1 - 1.0*i*i));
            answer += distR2 - distR1 + 1;
        }
        return answer * 4;
    }
}