import sys

R, C, T = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(R)]
#공기 청정기 위치
for i in range(R):
    if graph[i][0] == -1:
        air_location = i
        break

dx = [-1,1,0,0]
dy = [0,0,-1,1]
#미세먼지 확산
def diffusion(R,C):
    #각 위치에서의 확산 계수(확산량)
    diffusion_graph = [[0] * C for _ in range(R)]
    #확산 위치
    diffusion_xy = []
    for i in range(R):
        for j in range(C):
            #확산이 일어나기 위해 5이상 되어야 함
            if graph[i][j] >= 5:
                diffusion_graph[i][j] = graph[i][j] // 5
                diffusion_xy.append((i,j))
    #확산 시행
    for x, y in diffusion_xy:
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= R or ny >= C or graph[nx][ny] == -1:
                continue
            graph[nx][ny] += diffusion_graph[x][y]
            graph[x][y] -= diffusion_graph[x][y]

#공기 청정기
def air_clean(air_location,R,C):
    #반시계
    for i in range(air_location-1,0,-1):
        graph[i][0] = graph[i-1][0]
    for i in range(C-1):
        graph[0][i] = graph[0][i+1]
    for i in range(air_location):
        graph[i][C-1] = graph[i+1][C-1]
    for i in range(C-1,1,-1):
        graph[air_location][i] = graph[air_location][i-1]
    graph[air_location][1] = 0
    #시계
    for i in range(air_location+2,R-1):
        graph[i][0] = graph[i+1][0]
    for i in range(C-1):
        graph[R-1][i] = graph[R-1][i+1]
    for i in range(R-1,air_location+1,-1):
        graph[i][C-1] = graph[i-1][C-1]
    for i in range(C-1,1,-1):
        graph[air_location+1][i] = graph[air_location+1][i-1]
    graph[air_location+1][1] = 0

#T초동안 공기청정기 실행
for _ in range(T):
    diffusion(R,C)
    air_clean(air_location,R,C)

#미세먼지 량 계산
result = 2 #공기청정기 -1 2개 보상분
for g in graph:
    result += sum(g)
print(result)