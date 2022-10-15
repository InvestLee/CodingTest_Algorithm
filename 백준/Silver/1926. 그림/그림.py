from collections import deque

import sys
n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

dx = [-1,1,0,0]
dy = [0,0,-1,1]

#방문처리 및 방문한 노드 갯수를 반환하는 bfs
def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    area = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if not visited[nx][ny] and graph[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx,ny))
                area += 1
    return area

piture_num = 0
largest_area = 0
for i in range(n):
    for j in range(m):
        if not visited[i][j] and graph[i][j] == 1:
            temp_area = bfs(i,j)
            piture_num += 1 #조건 만족 시 그림 수 증가
            largest_area = max(largest_area, temp_area) #더 큰 그림 주입
print(piture_num)
print(largest_area)