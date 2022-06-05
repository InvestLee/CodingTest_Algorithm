import sys

#i-2에서 누워있는 두 개의 타일이 붙고 i-1에서는 세워져있는 한 개의 타일이 붙는다.

n = int(sys.stdin.readline().rstrip())
dp = [0, 1, 2]
for i in range(3,n+1):
    dp.append(dp[i-1]+dp[i-2]) #점화식
print(dp[n]%10007)