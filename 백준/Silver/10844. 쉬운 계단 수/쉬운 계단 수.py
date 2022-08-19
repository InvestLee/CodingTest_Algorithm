import sys

N = int(sys.stdin.readline().rstrip())
#dp[자릿수][숫자0~9]
dp = [[0]*10 for _ in range(N+1)]
#1~9 자릿수는 1회로 산정
for i in range(1,10):dp[1][i] = 1
#0은 1, 9는 8 한가지 경우의 계단수로 연결가능
#1~8은 두가지 경우의 계단수로 연결가능
for i in range(2,N+1):
    for j in range(0,10):
        if j == 0: dp[i][0] = dp[i-1][1] % 1000000000
        elif j == 9: dp[i][9] = dp[i-1][8] % 1000000000
        else: dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]) % 1000000000
print(sum(dp[N]) % 1000000000)