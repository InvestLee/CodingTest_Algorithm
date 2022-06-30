import sys
from collections import deque

INF = 1e9

N = int(sys.stdin.readline().rstrip())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

dx = [-1,1,0,0]
dy = [0,0,-1,1]

#물고기를 잡아먹을 수 있는 시간, 몇마리 잡아먹었는지 카운트
eat_time = 0
eat_count = 0
#사이즈
size = 2
#상어의 위치
for i in range(N):
    for j in range(N):
        if graph[i][j] == 9:
            x = i
            y = j
            graph[i][j] = 0 #아기상어 위치 초기화
            break

def bfs(x,y): #잡아먹을 수 있는 물고기까이의 거리를 저장
    dist = [[-1 for _ in range(N)] for _ in range(N)] #거리
    queue =  deque()
    queue.append((x,y))
    dist[x][y] = 0
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >=N:
                continue
            #크기가 같은 물고기까지 지나갈 수 있고 아직 방문안했을 때
            if graph[nx][ny] <= size and dist[nx][ny] == -1:
                queue.append((nx,ny))
                dist[nx][ny] = dist[x][y]+1
    return dist

#가장 가까운 거리의 물고기를 먹는 함수
def find(dist):
    x, y = 0,0
    min_dist = INF #최단 거리 초기화
    for i in range(N):
        for j in range(N):
            #잡아먹을 수 있는 물고기 일 때
            if dist[i][j] != -1 and 1 <= graph[i][j] < size:
                if dist[i][j] < min_dist:
                    x,y = i,j
                    min_dist = dist[i][j]
    #잡아먹을 물고기가 없는 경우
    if min_dist == INF:
        return -1
    else:
        return x, y, min_dist

while True:
    #가장 가까운 물고기를 먹는 함수
    fish_eat = find(bfs(x,y))
    #아무것도 못먹었다면
    if fish_eat == -1:
        print(eat_time)
        break
    else:
        x, y = fish_eat[0],fish_eat[1] #상어위치 이동
        eat_time += fish_eat[2]
        graph[x][y] = 0 #상어위치 초기화
        eat_count += 1
    #자기 크기만큼 물고기를 먹으면 레벨업
    if eat_count >= size:
        size += 1
        eat_count = 0