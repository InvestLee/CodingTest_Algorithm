import sys
from collections import deque

dx = [2,1,-2,-1,2,-1,-2,1] #나이트 이동 가능
dy = [1,2,-1,-2,-1,2,1,-2]

def bfs(x,y):
    queue = deque()
    queue.append((x,y))
    while queue:
        x,y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N: #경계값 넘으면 무시
                continue
            if shortest[nx][ny] == 0: #안가본 곳이면 간 횟수 더하기
                shortest[nx][ny] += shortest[x][y] + 1
                if nx == px and ny == py: #목적지에 도착하면 반환
                    return shortest[nx][ny]
                queue.append((nx,ny))

T = int(sys.stdin.readline().rstrip())
for i in range(T):
    N = int(sys.stdin.readline().rstrip())
    x, y = map(int, sys.stdin.readline().split())
    px, py = map(int, sys.stdin.readline().split())
    shortest = [[0]*N for i in range(N)]
    if x==px and y==py:
        print(0)
    else:
        print(bfs(x,y))