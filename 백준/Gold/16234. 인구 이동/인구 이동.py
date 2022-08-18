import sys
from collections import deque

N, L, R = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
move_true = False

def bfs(x,y):
    #국경 간 이동 유무
    global move_true
    q = deque()
    q.append((x,y))
    #방문 처리
    visited[x][y] = True
    #연합 인구수
    sum_human = graph[x][y]
    #연합 수
    count = 1
    #연합의 위치
    near_country = [(x,y)]
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if not visited[nx][ny] and L <= abs(graph[nx][ny]-graph[x][y]) <= R:
                sum_human += graph[nx][ny]
                count += 1
                visited[nx][ny] = True
                q.append((nx,ny))
                near_country.append((nx,ny))
    #인구 이동 발생 시
    if count > 1:
        move_true = True
        cal_human = sum_human//count
        for cx, cy in near_country:
            graph[cx][cy] = cal_human
    return move_true

#인구 이동 일수
day_result = 0
while True:
    visited = [[False]*N for _ in range(N)]
    move_true = False
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                move_true = bfs(i,j)
    if not move_true:
        break
    day_result += 1
print(day_result)