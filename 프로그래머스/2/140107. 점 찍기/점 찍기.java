class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dist;
        for(int i = 0; i <= d; i += k){
            dist = (long)distance(d,i);
            answer += dist / k + 1;
        }
        return answer;
    }
    
    public static double distance(long d, long x){
        return Math.sqrt(d*d - x*x);
    }
}