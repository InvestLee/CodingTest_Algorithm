class Solution {
    public int solution(int n) {
        return n / getGcd(n, 6);
    }
    
    public int getGcd(int a, int b){
        if (a % b == 0) {
            return b;
        }
        return getGcd(b, a % b);
    }
}