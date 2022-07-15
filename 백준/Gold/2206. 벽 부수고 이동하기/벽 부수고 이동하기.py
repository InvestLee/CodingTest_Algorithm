import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
graph = [list(map(int,input())) for _ in range(N)]
visited = [[[0,0] for _ in range(M)] for _ in range(N)] #[벽을 뚫기 전,벽을 뚫은 경우]
visited[0][0][0] = 1 #시작하는 칸 포함하여 카운트
dx = [-1,1,0,0]
dy = [0,0,-1,1]
result = -1 #bfs가 최종지점에 도달하지 못한 경우를 초기값 설정

q = deque()
q.append((0,0,0))
while q:
    x, y, z = q.popleft()
    if x == N-1 and y == M-1: #최종 지점 도달하면 결과값 저장
        result = visited[x][y][z]
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx >= N or ny < 0 or ny >= M: #범위를 벗어난 경우
            continue
        if graph[nx][ny] == 1 and z == 0: #아직 벽을 뚫지 않았고 벽을 직면한 경우
            visited[nx][ny][1] = visited[x][y][0] + 1
            q.append((nx,ny,1))
        elif graph[nx][ny] == 0 and visited[nx][ny][z] == 0: #아직 가지 않았고 벽이 아닌 경우
            visited[nx][ny][z] = visited[x][y][z] + 1
            q.append((nx,ny,z))

print(result)