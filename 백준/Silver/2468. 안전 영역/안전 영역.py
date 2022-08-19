import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dx = [0,0,-1,1]
dy = [-1,1,0,0]
visited = [[False]*N for _ in range(N)]

#이 지역의 최대 높이
max_height = 0
for g in graph:
    max_height = max(max_height,max(g))

#물에 안잠기는 연결된 영역구하는 bfs
def bfs(x,y,r):
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N  or ny < 0 or ny >= N:
                continue
            if not visited[nx][ny] and graph[nx][ny] > r:
                visited[nx][ny] = True
                q.append((nx,ny))

#최대 영역 수
result = 1
for r in range(1,max_height):
    visited = [[False]*N for _ in range(N)]
    cnt = 0
    for i in range(N):
        for j in range(N):
            if not visited[i][j] and graph[i][j] > r:
                bfs(i,j,r)
                cnt += 1
    result = max(result,cnt)
print(result)