import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
graph = []
for _ in range(N):
    graph.append(list(sys.stdin.readline().rstrip()))

#색약이 아닌 사람용 방문처리와 구간
Color_visited = [[False for _ in range(N)] for _ in range(N)] 
color_count = 0
#색약인 사람용 방문처리와 구간
Color_Blind_visited = [[False for _ in range(N)] for _ in range(N)]
blind_count = 0

#네 방향 좌표
dx = [-1,1,0,0]
dy = [0,0,-1,1]

#같은 영역의 색상을 모두 방문처리하는 bfs
def bfs(x,y,visited):
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True
    while queue:
        x, y = queue.popleft()
        #상하좌우 4방향
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            #범위를 벗어난 경우 무시
            if nx < 0 or nx >= N or ny < 0 or ny >= N or visited[nx][ny]:
                continue
            #같은 색상일 경우 같은 영역으로 지정
            if graph[x][y] == graph[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx,ny))

#색약이 아닌 사람부터 카운트
for i in range(N):
    for j in range(N):
        if Color_visited[i][j] == False:
            bfs(i,j,Color_visited)
            color_count += 1

#색약인 사람 전용 그래프로 변환
for i in range(N):
    for j in range(N):
        if graph[i][j] == 'G':
            graph[i][j] = 'R'

#색약인 사람이 보는 영역 카운트
for i in range(N):
    for j in range(N):
        if Color_Blind_visited[i][j] == False:
            bfs(i,j,Color_Blind_visited)
            blind_count += 1

print(color_count, blind_count)