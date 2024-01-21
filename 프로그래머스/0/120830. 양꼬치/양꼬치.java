class Solution {
    public int solution(int n, int k) {
        int yang = n * 12000;
        int buy = (k - n / 10);
        if(buy < 0) buy = 0; 
        int cola = buy * 2000;
        
        int answer = yang+cola;
        return answer;
    }
}