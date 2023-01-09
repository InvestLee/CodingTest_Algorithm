import sys
N = int(sys.stdin.readline().rstrip())
P = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
count = [0,0] #흰색 파란색 색종이 갯수

def half(x,y,N):
    color = P[x][y] #처음 지정 색깔 선택
    for i in range(x,x+N): #모든 영역에서 색깔이 안같으면 4갈래로 나누어 버리기
        for j in range(y,y+N): 
            if color != P[i][j]:
                half(x,y,N//2)
                half(x+N//2,y,N//2)
                half(x,y+N//2,N//2)
                half(x+N//2,y+N//2,N//2)
                return #밑에 카운트를 세지 않게 리턴시킨다.
    if color == 0:
        count[0] += 1
    else:
        count[1] += 1

half(0,0,N)
print(count[0])
print(count[1])