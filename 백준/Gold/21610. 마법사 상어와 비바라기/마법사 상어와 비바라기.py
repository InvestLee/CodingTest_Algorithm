import sys

N, M = map(int, sys.stdin.readline().split())
basket = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
move_cloud = [list(map(int, sys.stdin.readline().split())) for _ in range(M)]

#none, ←, ↖, ↑, ↗, →, ↘, ↓, ↙
dx = [0,0,-1,-1,-1,0,1,1,1]
dy = [0,-1,-1,0,1,1,1,0,-1]

#대각선 4방향
gx = [-1,1,-1,1]
gy = [1,1,-1,-1]

#구름의 위치
cloud_location = [[N-1,0],[N-1,1],[N-2,0],[N-2,1]]
for m in move_cloud:
    #구름의 이동
    for i in range(len(cloud_location)):
        cloud_location[i][0] = (cloud_location[i][0]+dx[m[0]]*m[1]+N*m[1]) % N
        cloud_location[i][1] = (cloud_location[i][1]+dy[m[0]]*m[1]+N*m[1]) % N
    #비바라기
    for cx, cy in cloud_location:
        basket[cx][cy] += 1
    #물복사 버그
    for cx, cy in cloud_location:
        for i in range(4):
            nx = cx + gx[i]
            ny = cy + gy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if basket[nx][ny] > 0:
                basket[cx][cy] += 1
    #구름이 생성된 칸이 아니어야 되는 조건을 만족하기 위한 임시 구름 위치
    temp_location = set([(tx, ty) for tx, ty in cloud_location])
    #구름 삭제
    cloud_location = []
    #구름 생성
    for i in range(len(basket)):
        for j in range(len(basket[i])):
            if basket[i][j] > 1 and (i, j) not in temp_location:
                cloud_location.append([i,j])
                basket[i][j] -= 2

#바구니에 들어있는 물의 양의 합
result = 0
for b in basket:
    result += sum(b)

print(result)