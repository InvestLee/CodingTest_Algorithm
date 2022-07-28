import sys
from collections import deque

dx = [-1,1,0,0]
dy = [0,0,-1,1]

N, M = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
max_safety = 0

#벽의 갯수
wall_count = 3
for i in range(N):
    wall_count += graph[i].count(1)

#바위러스 위치
virus = []
for i in range(N):
    for j in range(M):
        if graph[i][j] == 2:
            virus.append((i,j))

#최대 안전 영역 계산 bfs
def bfs():
    global max_safety
    visited = [[False for _ in range(M)] for _ in range(N)]
    count = 0
    q = deque()
    for v in virus:
        q.append(v)
        visited[v[0]][v[1]] = True
        count += 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if visited[nx][ny] == False and graph[nx][ny] == 0:
                q.append((nx,ny))
                visited[nx][ny] = True
                count += 1
    max_safety = max(max_safety,N*M-count-wall_count)

#벽 3개 세우고 bfs돌리기
def wall(start,cnt):
    if cnt == 3:
        bfs()
        return
    for i in range(start,N*M):
        wx = i // M
        wy = i % M
        if graph[wx][wy] == 0:
            graph[wx][wy] = 1
            wall(i,cnt+1)
            graph[wx][wy] = 0

wall(0,0)
print(max_safety)
