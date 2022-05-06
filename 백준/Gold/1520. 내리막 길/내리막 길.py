import sys
sys.setrecursionlimit(10**6)

#아직 안갔다는 의미로 -1, 경로가 없다는 뜻으로 0
#1이상의 값은 경로가 있다는 뜻으로 이전 지점에 더해준다
M, N = map(int, sys.stdin.readline().split())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(M)]
dp = [[-1] * N for _ in range(M)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def dfs(x,y):
    if x == M-1 and y == N-1: #목적지에 도착했으면 이동한 칸에 대해 모두 1더한다.
        return 1
    if dp[x][y] != -1: #이미 방문한 곳이라면 재귀를 끝내고 값을 반환(dp)
        return dp[x][y]
    dp[x][y] = 0 #얘가 끝날떄까지 0이면 경로가 없다는 뜻
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < M and ny >= 0 and ny < N:
            if arr[nx][ny] < arr[x][y]:
                dp[x][y] += dfs(nx,ny) #경로가 있다는 것을 이전 지점에 더해줌으로 값을 구한다.
    return dp[x][y] #dfs가 끝났다면 재귀를 끝내고 값을 반환

print(dfs(0,0))