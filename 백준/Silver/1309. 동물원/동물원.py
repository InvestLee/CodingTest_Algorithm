import sys

N = int(sys.stdin.readline().rstrip())
#i번째 우리에 아무것도 없는 경우
#=> i-1가 우리에 아무것도 없는 경우+왼쪽에 있는 경우+오른쪽에 있는 경우
#i번째 왼쪽에 있는 경우
#=> i-1 없+ i-1 우
#i번째 오른쪽에 있는 경우
#=> i-1 없+ i-1 좌
dp = [[1]*3 for _ in range(N)]
for i in range(1,len(dp)):
    dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2]) % 9901
    dp[i][1] = (dp[i-1][0]+dp[i-1][2]) % 9901
    dp[i][2] = (dp[i-1][0]+dp[i-1][1]) % 9901
print(sum(dp[N-1])%9901)