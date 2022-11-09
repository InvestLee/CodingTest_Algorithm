#DFS
import sys

r, c = map(int, sys.stdin.readline().split())
board = [list(sys.stdin.readline().rstrip()) for _ in range(r)]

dx = [-1,1,0,0]
dy = [0,0,-1,1]
route_alpha = set(board[0][0])
result = 0

def dfs(x,y):
    global result
    result = max(result,len(route_alpha))
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= r or ny >= c:
            continue
        if board[nx][ny] not in route_alpha:
            route_alpha.add(board[nx][ny])
            dfs(nx,ny)
            route_alpha.remove(board[nx][ny])

dfs(0,0)
print(result)