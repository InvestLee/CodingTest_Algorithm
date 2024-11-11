class Solution {
    public int solution(int[][] matrix_sizes) {
        int len = matrix_sizes.length;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len-i; j++){
                int a = j;
                int b = j+i;
                if(a != b) dp[a][b] = Integer.MAX_VALUE;
                for(int k = a; k < b; k++){
                    dp[a][b] = Math.min(dp[a][b], dp[a][k]+dp[k+1][b]
                                       + matrix_sizes[a][0]
                                       * matrix_sizes[k][1]
                                       * matrix_sizes[b][1]);
                }
            }
        }
        return dp[0][len-1];
    }
}