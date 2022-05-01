import sys
from collections import deque

#bfs로 인접한 부분의 1을 모두 0으로 만들면 count를 상승시키는 방법으로 시행

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(graph, x, y):
    queue = deque()
    queue.append((x,y))
    graph[x][y] = 0
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx,ny))
    return

T = int(sys.stdin.readline().rstrip())

for _ in range(T):
    count = 0
    N, M, K = map(int, sys.stdin.readline().split())
    graph = [[0]*M for _ in range(N)]
    for _ in range(K):
        x, y = map(int, sys.stdin.readline().split())
        graph[x][y] = 1
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                bfs(graph, i, j)
                count += 1
    print(count)

