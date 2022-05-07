import sys

N, K = map(int, sys.stdin.readline().split())
arr = [[0,0]]
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))
dp = [[0]*(K+1) for i in range(N+1)]

for i in range(1,N+1):
    for j in range(1,K+1):
        if j < arr[i][0]: #현재 물건의 무게보다 현재 설정한 무게가 작다면 이전까지의 물건들 입력
            dp[i][j] = dp[i-1][j] 
        else: #현재 물건의 가치+이전까지의 물건들
            dp[i][j] = max(arr[i][1]+dp[i-1][j-arr[i][0]],dp[i-1][j] )
print(dp[N][K])