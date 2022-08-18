import sys

N = int(sys.stdin.readline().rstrip())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

dx = [0,1]
dy = [-1,0]
#토네이도 이동거리
cnt = 1
#토네이도 방향
direction = 1
#격자 밖으로 나간 모래
result = 0
x, y = N//2, N//2
while x!=0 or y!=0:
    #토네이도 이동
    for i in range(2):
        for j in range(cnt):
            #이동 모래량
            move_sand = 0
            x = x+dx[i]*direction
            y = y+dy[i]*direction
            if y < 0:
                break
            #모래 이동 5%
            nx = x+dx[i]*direction*2
            ny = y+dy[i]*direction*2
            if nx < 0 or ny < 0 or nx >= N or ny >= N: result += (arr[x][y] // 20)
            else: arr[nx][ny] += arr[x][y] // 20
            move_sand += arr[x][y] // 20
            #모래 이동 7%
            nx = x+dx[(i+1)%2]*direction
            ny = y+dy[(i+1)%2]*direction
            if nx < 0 or ny < 0 or nx >= N or ny >= N: result += (arr[x][y] * 7 // 100)
            else: arr[nx][ny] += arr[x][y] * 7 // 100
            move_sand += arr[x][y] * 7 // 100
            #모래 이동 7%
            nx = x+dx[(i+1)%2]*direction*(-1)
            ny = y+dy[(i+1)%2]*direction*(-1)
            if nx < 0 or ny < 0 or nx >= N or ny >= N: result += (arr[x][y] * 7 // 100)
            else: arr[nx][ny] += arr[x][y] * 7 // 100
            move_sand += arr[x][y] * 7 // 100
            #모래 이동 2%
            nx = x+dx[(i+1)%2]*direction * 2
            ny = y+dy[(i+1)%2]*direction * 2
            if nx < 0 or ny < 0 or nx >= N or ny >= N: result += (arr[x][y] // 50)
            else: arr[nx][ny] += arr[x][y] // 50
            move_sand += arr[x][y] // 50
            #모래 이동 2%
            nx = x+dx[(i+1)%2]*direction*(-1) * 2
            ny = y+dy[(i+1)%2]*direction*(-1) * 2
            if nx < 0 or ny < 0 or nx >= N or ny >= N: result += (arr[x][y] // 50)
            else: arr[nx][ny] += arr[x][y] // 50
            move_sand += arr[x][y] // 50
            #모래 이동 10%
            nx = x+dx[i]*direction+dx[(i+1)%2]*direction
            ny = y+dy[i]*direction+dy[(i+1)%2]*direction
            if nx < 0 or ny < 0 or nx >= N or ny >= N: result += (arr[x][y] // 10)
            else: arr[nx][ny] += arr[x][y] // 10
            move_sand += arr[x][y] // 10
            #모래 이동 10%
            nx = x+dx[i]*direction+dx[(i+1)%2]*direction*(-1)
            ny = y+dy[i]*direction+dy[(i+1)%2]*direction*(-1)
            if nx < 0 or ny < 0 or nx >= N or ny >= N: result += (arr[x][y] // 10)
            else: arr[nx][ny] += arr[x][y] // 10
            move_sand += arr[x][y] // 10
            #모래 이동 1%
            nx = x+dx[i]*direction*(-1)+dx[(i+1)%2]*direction
            ny = y+dy[i]*direction*(-1)+dy[(i+1)%2]*direction
            if nx < 0 or ny < 0 or nx >= N or ny >= N: result += (arr[x][y] // 100)
            else: arr[nx][ny] += arr[x][y] // 100
            move_sand += arr[x][y] // 100
            #모래 이동 1%
            nx = x+dx[i]*direction*(-1)+dx[(i+1)%2]*direction*(-1)
            ny = y+dy[i]*direction*(-1)+dy[(i+1)%2]*direction*(-1)
            if nx < 0 or ny < 0 or nx >= N or ny >= N: result += (arr[x][y] // 100)
            else: arr[nx][ny] += arr[x][y] // 100
            move_sand += arr[x][y] // 100
            #모래 a로 이동
            nx = x+dx[i]*direction
            ny = y+dy[i]*direction
            if nx < 0 or ny < 0 or nx >= N or ny >= N: result += arr[x][y]-move_sand
            else: arr[nx][ny] += arr[x][y]-move_sand
            arr[x][y] -= arr[x][y]
            if x==0 and y==0:
                break
        if x==0 and y==0:
            break
    direction *= -1
    cnt += 1
print(result)