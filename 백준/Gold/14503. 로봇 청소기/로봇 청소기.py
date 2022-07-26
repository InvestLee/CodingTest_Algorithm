import sys

N, M = map(int, sys.stdin.readline().split())
r, c, d = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
graph[r][c] = 2 #청소함
result = 1

dr = [0,-1,0,1] #북동남서의 왼쪽은
dc = [-1,0,1,0] #서북동남

while True:
    for i in range(4): #네 방향 모두 청소되어 있거나 벽인 경우 판별
        nr = r + dr[i]
        nc = c + dc[i]
        if nr < 0 or nr >= N or nc < 0 or nc >= M:
            continue
        if graph[nr][nc] == 0:
            break
    else: #후진할 수 있는지 판별
        nr = r-dr[(d+1)%4]
        nc = c-dc[(d+1)%4]
        if nr < 0 or nr >= N or nc < 0 or nc >= M or graph[nr][nc] == 1:
            break
        elif graph[nr][nc] == 2: #후진
            r = r-dr[(d+1)%4]
            c = c-dc[(d+1)%4]
            continue
    nr = r + dr[d]
    nc = c + dc[d]
    if nr < 0 or nr >= N or nc < 0 or nc >= M:
        continue
    if graph[nr][nc] == 0:
        d = (d+3) % 4 #회전
        graph[nr][nc] = 2
        r, c = nr, nc
        result += 1
        continue
    else:
        d = (d+3) % 4 #회전

print(result)