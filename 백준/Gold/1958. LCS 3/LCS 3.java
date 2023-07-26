import java.io.*;

//백준 1958 LCS 3
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        char[] str3 = br.readLine().toCharArray();

        int[][][] dp = new int[str1.length+1][str2.length+1][str3.length+1];

        for(int i = 1; i <= str1.length; i++){
            for(int j = 1; j <= str2.length; j++){
                for(int k = 1; k <= str3.length; k++){
                    if(str1[i-1] == str2[j-1] && str2[j-1] == str3[k-1]){
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k],Math.max(dp[i][j-1][k],dp[i][j][k-1]));
                    }
                }
            }
        }

        bw.write(dp[str1.length][str2.length][str3.length]+"");
        br.close();
        bw.flush();
        bw.close();
    }
}
