class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] accSum = new int[sequence.length+1];
        for(int i = 0; i < sequence.length; i++){
            accSum[i+1] = sequence[i]+accSum[i];
        }
        int start = 0;
        int end = 1;
        int len = accSum.length;
        int temp;
        while(end > start && end < accSum.length){
            temp = accSum[end] - accSum[start];
            if(temp > k){
                start++;
            } else {
                if(temp == k && end - start < len){
                    answer[0] = start;
                    answer[1] = end - 1;
                    len = end - start;
                }
                end++;
            }
        }
        
        return answer;
    }
}