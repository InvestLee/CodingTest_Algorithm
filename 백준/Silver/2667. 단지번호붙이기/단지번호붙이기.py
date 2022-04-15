from collections import deque
import sys
N = int(sys.stdin.readline().rstrip())
graph = [] 
result = 0 #영역의 수
quan = [] #각 영역의 단지 수
count = 0 #단지 수
for i in range(N):
    graph.append(list(map(int, sys.stdin.readline().rstrip())))

dx = [-1, 1, 0, 0] #4가지 방향
dy = [0, 0, -1, 1]

def bfs(x,y):
    queue = deque() #큐 시작
    queue.append((x,y)) #일단 처음꺼는 무조건 1인것만 넣을거라서
    count = 1 #처음꺼
    graph[x][y] = 0 #방문했으니 0
    while queue:
        x, y = queue.popleft()
        for i in range(4): #4가지 방향 다 하게
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= N or nx <= -1 or ny >= N or ny <= -1: #벽 붙인친거는 무시 다음 반복으로
                continue
            if graph[nx][ny] == 1: #방문안했으면
                graph[nx][ny] = 0 #방문처리
                count += 1 #단지수 상승
                queue.append((nx,ny)) #주변이 다 0이면 큐가 남지 않는다.
    quan.append(count)

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1: #방문안한거는
            result += 1 #그 영역다 0가 될테니 1개 올려도 됨
            bfs(i,j) #영역 다 하기
quan = sorted(quan)

print(result)
for i in quan:
    print(i)
