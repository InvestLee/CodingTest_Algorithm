import sys

#arr[i][j]까지 더하는 경우의 수는 arr[다른 행][j-1],arr[다른 행][j-2] 2가지이다.
#arr[같은 행][j-2]도 더할 수 있지만 arr[다른 행][j-1]과 같은 경우이므로 제외

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    n = int(sys.stdin.readline().rstrip())
    arr = [list(map(int, sys.stdin.readline().split())) for _ in range(2)]
    if n == 1:
        print(max(arr[0][n-1],arr[1][n-1]))
        continue
    arr[0][1] += arr[1][0] #반복문 초기 설정을 위한 선 계산
    arr[1][1] += arr[0][0] #반복문 초기 설정을 위한 선 계산
    for i in range(2,n):
        arr[0][i] += max(arr[1][i-1],arr[1][i-2])
        arr[1][i] += max(arr[0][i-1],arr[0][i-2])
    print(max(arr[0][n-1],arr[1][n-1]))