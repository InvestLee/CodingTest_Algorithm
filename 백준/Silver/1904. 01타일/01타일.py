import sys

#피보나치 수열과 같음(2단계 전에 00을 더하는 경우의 수+ 1단계 전에 1을 더하는 경우의 수)
N = int(sys.stdin.readline().rstrip())
dp = [0]*(N+1)
dp[0], dp[1] = 1, 1
for i in range(2,N+1):
    dp[i] = (dp[i-1]+dp[i-2]) % 15746
print(dp[N])