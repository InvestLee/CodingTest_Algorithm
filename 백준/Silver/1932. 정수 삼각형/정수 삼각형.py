import sys

N = int(sys.stdin.readline().rstrip())
triangle = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

for i in range(1,N):
    for j in range(i+1):
        if j == 0: #왼쪽 변(선택할 수 있는 경로가 하나밖에 없음)
            triangle[i][j] +=  triangle[i-1][j]
        elif j == i: #오른쪽 변(선택할 수 있는 경로가 하나밖에 없음)
            triangle[i][j] +=  triangle[i-1][j-1]
        else: #내부
            triangle[i][j] += max(triangle[i-1][j],triangle[i-1][j-1])

print(max(triangle[N-1]))