import sys

N = int(sys.stdin.readline().rstrip())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dp = [[0 for _ in range(N)] for _ in range(N)]
dp[0][0] = 1

#방문 횟수를 출력하는 DP
for i in range(N):
    for j in range(N):
        if i == N-1 and j  == N-1:
            print(dp[i][j])
            break
        if j + graph[i][j] < N:
            dp[i][j+graph[i][j]] += dp[i][j]
        if i + graph[i][j] < N:
            dp[i+graph[i][j]][j] += dp[i][j]