import java.util.*;

class Solution {
    int[][] dp;
    public int solution(int n, int[] money) {
        dp = new int[money.length+1][n+1];
        for(int i = 1; i <= money.length; i++){
            for(int j = 0; j <= n; j++){
                if(j==0){
                    dp[i][j] = 1;
                }
                else if(j < money[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j-money[i-1]]) % 1000000007;
                }
            }
        }
        
        return dp[money.length][n];
    }
}