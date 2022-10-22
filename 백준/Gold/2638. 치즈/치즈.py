import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(N,M):
    q = deque()
    q.append((0,0)) #모눈종이 맨 가장자리는 치즈가 놓이지 않음
    visited = [[False]*M for i in range(N)]
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            if not visited[nx][ny] and graph[nx][ny] == 0:
                visited[nx][ny] = True
                q.append((nx,ny)) #외부 공기면으로 이동
            elif graph[nx][ny] != 0:
                graph[nx][ny] += 1 #치즈가 닿는 변 수 계산
    #녹는 치즈 적용
    for i in range(N):
        for j in range(M):
            if graph[i][j] > 2:
                graph[i][j] = 0
            elif graph[i][j] == 2:
                graph[i][j] = 1

result = 1
while True:
    bfs(N,M)
    exist_cheese = set() #치즈가 남아있는지 확인
    for g in graph:
        exist_cheese.update(g)
    if len(exist_cheese) == 1:
        break
    result += 1
print(result)