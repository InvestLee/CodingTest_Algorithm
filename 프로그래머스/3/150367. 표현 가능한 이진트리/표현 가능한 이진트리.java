class Solution {
    public static int[] answer;
    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            String binary =  Long.toBinaryString(numbers[i]);
            int j = 0;
            while((int)Math.pow(2, j)-1 < binary.length()){
                j++;
            }
            while((int)Math.pow(2, j)-1 != binary.length()){
                binary = "0" + binary;
            } 
            if(dfs(binary)) answer[i] = 1;
        }
        return answer;
    }
    
    public static boolean dfs(String num){
        int mid = (num.length()-1) / 2;
        String left = num.substring(0,mid);
        String right = num.substring(mid+1,num.length());
        if(num.charAt(mid) == '0' && 
           (left.charAt((left.length()-1)/2) == '1' ||
           right.charAt((right.length()-1)/2) == '1')
          ) return false;
        
        boolean result = true;
        if(left.length() >= 3){
            result = dfs(left);
            if(result) result = dfs(right);
        }
        
        return result;
    }
}