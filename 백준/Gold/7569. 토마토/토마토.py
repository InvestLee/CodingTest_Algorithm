import sys
from collections import deque

M, N, H = map(int, sys.stdin.readline().split())
box = []
for _ in range(H):
    box_stair = []
    for _ in range(N):
        box_stair.append(list(map(int, sys.stdin.readline().split())))
    box.append(box_stair)

#여섯 방향 이동
dx = [-1,1,0,0,0,0]
dy = [0,0,-1,1,0,0]
dz = [0,0,0,0,-1,1]

#bfs를 이용하기 위해 익은 토마토를 모두 큐에 추가하여 시작하도록 한다.
queue = deque()
for i in range(H):
    for j in range(N):
        for k in range(M):
            if box[i][j][k] == 1:
                queue.append((i,j,k))
while queue:
    x, y, z = queue.popleft()
    for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        nz = z + dz[i]
        #범위에 벗어날 경우
        if nx < 0 or nx >= H or ny < 0 or ny >= N or nz < 0 or nz >= M:
            continue
        #안익은 토마토가 있는 경우
        if box[nx][ny][nz] == 0:
            box[nx][ny][nz] = box[x][y][z] + 1 #토마토가 익는 데 걸리는 시간 기록(처음 1은 뺴줘야 함)
            queue.append((nx,ny,nz))

result = 0
for i in range(H):
    for j in range(N):
        for k in range(M):
            if box[i][j][k] == 0:
                print(-1)
                exit(0)
            else:
                result = max(result,box[i][j][k]-1)
print(result)