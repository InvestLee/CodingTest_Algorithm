import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
board = [list(sys.stdin.readline().rstrip()) for _ in range(n)]
#적색 공(rx, ry) 청색 공(bx, by) 체크 
visited = [[[[False] * m for _ in range(n)]for _ in range(m)]for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def moveBead(x, y, dx, dy):
    count = 0
    while board[x+dx][y+dy] != '#' and board[x][y] != 'O':
        x += dx
        y += dy
        count += 1
    return x, y, count

def escapeBead():
    rx, ry, bx, by = 0,0,0,0
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R' : rx, ry = i, j
            elif board[i][j] == 'B' : bx, by = i, j
    q = deque()
    q.append((rx,ry,bx,by,1))
    visited[rx][ry][bx][by] = True

    while q:
        rx, ry, bx, by, depth = q.popleft()
        if depth > 10:
            break
        for i in range(4):
            nrx, nry, rcount = moveBead(rx,ry,dx[i],dy[i])
            nbx, nby, bcount = moveBead(bx,by,dx[i],dy[i])
            if board[nbx][nby] != 'O':
                if board[nrx][nry] == 'O':
                    print(depth)
                    return
                if nrx == nbx and nry == nby:
                    if rcount > bcount:
                        nrx -= dx[i]
                        nry -= dy[i]
                    else:
                        nbx -= dx[i]
                        nby -= dy[i]
                if not visited[nrx][nry][nbx][nby]:
                    visited[nrx][nry][nbx][nby] = True
                    q.append((nrx,nry,nbx,nby,depth+1))
    print(-1)

escapeBead()