import sys
from collections import deque

M, N = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

dx = [-1,1,0,0]
dy = [0,0,-1,1]

#큐에 토마토가 있는 위치를 미리 입력하면 LIFO의 원리로 처음 익은 토마토들이 번갈아가면서 진행됨
queue = deque()
for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            queue.append((i,j))

#한번만 실행할 거라서 매개변수는 넣지 않는다.
def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            #범위를 벗어난 경우
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            #익지않은 토마도가 있는 경우(-1을 비롯하여 다음에 올 토마토가 익기 시작하면 건들지 않는다.)
            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y]+1
                queue.append((nx,ny))
    return

#bfs 실행
bfs()

#토마토가 모두 익지는 못하는 경우
count = 0
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            count += 1

if count > 0:
    print(-1)
else:
    print(max(map(max, graph))-1)
