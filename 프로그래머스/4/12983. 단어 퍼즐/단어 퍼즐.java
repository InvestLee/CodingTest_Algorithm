class Solution {
    public int solution(String[] strs, String t) {
        int[] dp = new int[t.length() + 1];
        for(int i = 1; i < t.length() + 1; i++){
            for(int j = 0; j < strs.length; j++){
                if(i - strs[j].length() < 0) continue;
                if(strs[j].equals(t.substring(i - strs[j].length(), i))){
                    if(i - strs[j].length() == 0){
                        dp[i] = 1;
                    }
                    else if(dp[i - strs[j].length()] > 0){
                        dp[i] = dp[i] == 0 ? dp[i - strs[j].length()] + 1
                            : Math.min(dp[i], dp[i - strs[j].length()] + 1);
                    }
                }
            }
        }
        
        if(dp[t.length()] == 0) return -1;
        return dp[t.length()];
    }
}