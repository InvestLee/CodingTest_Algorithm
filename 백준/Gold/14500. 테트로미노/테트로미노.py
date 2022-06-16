import sys

N, M = map(int, sys.stdin.readline().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().split())))
visited = [[False for _ in range(M)] for _ in range(N)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]

max_Tetro = 0

#한 줄로 이을 수 있는 도형 계산
def dfs(x,y,cnt,sum_tetro):
    global max_Tetro
    if cnt == 3:
        max_Tetro = max(max_Tetro,sum_tetro)
        return 
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx >= N or ny < 0 or ny >= M or visited[nx][ny]:
            continue
        visited[nx][ny] = True    
        dfs(nx,ny,cnt+1,sum_tetro+graph[nx][ny])
        visited[nx][ny] = False

for i in range(N):
    for j in range(M):
        visited[i][j] = True
        dfs(i,j,0,graph[i][j])
        visited[i][j] = False

#한 줄로 이을 수 없는 ㅗ ㅜ ㅏ ㅓ 계산
for i in range(N-1):
    for j in range(1,M-1):
        max_Tetro = max(max_Tetro,graph[i][j]+graph[i][j-1]+graph[i][j+1]+graph[i+1][j])
for i in range(1,N):
    for j in range(1,M-1):
        max_Tetro = max(max_Tetro,graph[i][j]+graph[i][j-1]+graph[i][j+1]+graph[i-1][j])
for i in range(1,N-1):
    for j in range(0,M-1):
        max_Tetro = max(max_Tetro,graph[i][j]+graph[i-1][j]+graph[i+1][j]+graph[i][j+1])
for i in range(1,N-1):
    for j in range(1,M):
        max_Tetro = max(max_Tetro,graph[i][j]+graph[i-1][j]+graph[i+1][j]+graph[i][j-1])

print(max_Tetro)