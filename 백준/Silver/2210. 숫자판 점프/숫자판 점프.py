import sys
sys.setrecursionlimit(int(1e9))

graph = [list(map(int, sys.stdin.readline().split())) for _ in range(5)]
dx = [0,0,-1,1]
dy = [-1,1,0,0]
set_route = set()

def dfs(x,y,cnt,s):
    #6열이 되면 set 추가
    if cnt == 6:
        set_route.add(s)
        return
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx >= 5 or ny < 0 or ny >= 5:
            continue
        #다음 문자 입력
        dfs(nx,ny,cnt+1,s+str(graph[nx][ny]))

for i in range(5):
    for j in range(5):
        dfs(i,j,0,"")
print(len(set_route))