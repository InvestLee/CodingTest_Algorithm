import sys

#다이나믹 프로그래밍
#2*n 직사각형을 채우는 경우의 수는 
#2*(n-2)일때 〓랑 □를 붙일 수 있으므로 곱하기 2와
#2*(n-1)일때 |를 붙일 수 있으므로 곱하기 1의 합과 같음

n = int(sys.stdin.readline().rstrip())
dp = [0]*1001
dp[1] = 1
dp[2] = 3
for i in range(3,1001):
    dp[i] = (dp[i-1]+dp[i-2]*2)%10007
print(dp[n])