import sys

n = int(sys.stdin.readline().rstrip())
grape = [0] * 10000
for i in range(n):
    grape[i] = int(sys.stdin.readline().rstrip())
grape.append([0]*10000)
dp = [0]*10000
dp[0] = grape[0]
dp[1] = grape[1] + grape[0]
dp[2] = max(grape[1]+grape[2],grape[2]+dp[0],dp[1])
dp[3] = max(grape[3]+dp[1],grape[3]+grape[2]+dp[0],grape[2]+grape[1])
for i in range(4,n):
    dp[i] = max(grape[i]+grape[i-1]+dp[i-3],grape[i]+dp[i-2],grape[i-1]+grape[i-2]+dp[i-4])
print(dp[n-1])