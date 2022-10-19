import sys

N = int(sys.stdin.readline().rstrip())
house = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
#dp[세로 위치][가로 위치][방향]
dp = [[[0]*3 for _ in range(N)]for _ in range(N)]

#가장 윗부분의 경우의 수
for i in range(1, N):
    if house[0][i] == 0:
        dp[0][i][0] = 1
    else:
        break

for i in range(1, N):
    for j in range(2,N):
        #대각선 이동
        if house[i][j] == 0 and house[i-1][j] == 0 and house[i][j-1] == 0:
            dp[i][j][2] = sum(dp[i-1][j-1]) #3가지 방향 모두 가능
        #가로 세로 이동
        if house[i][j] == 0:
            dp[i][j][0] = dp[i][j-1][0]+dp[i][j-1][2] #가로 대각선
            dp[i][j][1] = dp[i-1][j][1]+dp[i-1][j][2] #세로 대각선

print(sum(dp[-1][-1]))

'''시간초과
from collections import deque

#[가로,대각선,세로]
dx = [0,1,1]
dy = [1,1,0]

result = 0

q = deque()
q.append((0,1,0))
while q:
    x, y, pipe = q.popleft()
    #파이프 방향에 따른 이동
    if pipe == 0: #가로
        start = 0
        end = 2
    elif pipe == 1: #대각선
        start = 0
        end = 3
    else: #세로
        start = 1
        end = 3
    for i in range(start,end):
        nx = x + dx[i]
        ny = y + dy[i]
        #집에서 벗어나거나 벽에 막힌 경우
        if nx < 0 or ny < 0 or nx >= N or ny >= N or house[nx][ny] == 1:
            continue
        #대각선일 떄 벽을 긁는 경우
        if i == 1 and (house[nx-1][ny] == 1 or house[nx][ny-1] == 1):
            continue
        house[nx][ny] -= 1
        q.append((nx,ny,i))

if house[N-1][N-1] == 1: print(0)
else: print(abs(house[N-1][N-1]))
'''