class Solution {
    public int solution(int[] numbers, int n) {
        if(numbers[0] > n) return numbers[0];
        for(int i = 1; i < numbers.length; i++){
            numbers[i] += numbers[i-1];
            if(numbers[i] > n) return numbers[i];
        }
        return 0;
    }
}