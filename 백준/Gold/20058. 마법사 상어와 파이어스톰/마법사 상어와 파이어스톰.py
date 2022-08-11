import sys
from copy import deepcopy
from collections import deque

N, Q = map(int, sys.stdin.readline().split())
A = [list(map(int, sys.stdin.readline().split())) for _ in range(2**N)]
L = list(map(int, sys.stdin.readline().split()))

dx = [-1,1,0,0]
dy = [0,0,-1,1]

for rotate in L:
    #회전
    rotate_A = [[0] * (2**N) for _ in range(2**N)]
    #부분 격자
    for i in range(0,2**N,2**rotate):
        for j in range(0,2**N,2**rotate):
            #부분 격자 내 회전(오른쪽 열부터 채워 나가기 위해 i2 j2를 뒤집음)
            for i2 in range(2**rotate):
                for j2 in range(2**rotate):
                    rotate_A[i+j2][j+2**rotate-1-i2] = A[i+i2][j+j2]
    A = deepcopy(rotate_A)
    
    #얼음이 3칸 미만으로 인접한 부분 줄이기
    for i in range(2**N):
        for j in range(2**N):
            count = 0
            for k in range(4):
                mx = i + dx[k]
                my = j + dy[k]
                if mx < 0 or mx >= 2**N or my < 0 or my >= 2**N:
                    continue
                if A[mx][my] > 0:
                    count += 1
            if count < 3 and rotate_A[i][j] > 0:
                #만약 이전 칸에 얼음이 녹아서 0이 되면 영향을 끼칠 수 있으므로
                #A를 기준으로 검토하여 rotate_A에서 녹이는 작업 후 deepcopy를 실행
                rotate_A[i][j] -= 1
    A = deepcopy(rotate_A)

#얼음의 합 계산
sum_result = 0
for i in range(2**N):
    sum_result += sum(A[i])

#가장 큰 덩어리가 차지하는 칸의 개수 계산
def bfs(x,y):
    q = deque()
    q.append((x,y))
    A[x][y] = 0
    cnt = 1
    while q:
        x, y = q.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if nx < 0 or nx >= 2**N or ny < 0 or ny >= 2**N:
                continue
            if A[nx][ny] > 0:
                cnt += 1
                q.append((nx,ny))
                A[nx][ny] = 0
    return cnt

block_result = 0
for i in range(2**N):
    for j in range(2**N):
        if A[i][j] > 0:
            block_result = max(block_result,bfs(i,j))

print(sum_result)
print(block_result)