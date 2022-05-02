import sys

d = [[[0]*101 for _ in range(101)] for _ in range(101)] #메모이제이션

def w(a,b,c):
    if a <= 0 or b <= 0 or c <= 0:
        d[a][b][c] = 1
        return d[a][b][c]
    if d[a][b][c] != 0:
        return d[a][b][c]
    if a > 20 or b > 20 or c > 20:
        d[a][b][c] = d[20][20][20]
        return d[a][b][c]
    if a < b and b < c:
        d[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
        return d[a][b][c]
    else:
        d[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
        return d[a][b][c]

a,b,c=0,0,0
while True:
    a, b, c = map(int, sys.stdin.readline().split())
    if a == -1 and b == -1 and c == -1:
        break
    w(20,20,20) #함수 안에서 d[20][20][20]이 정의가 되어있지 않으므로 정의 후 출력
    print('w(%d, %d, %d) = %d'%(a, b, c, w(a,b,c)))