import sys

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    M, N, x, y = map(int, sys.stdin.readline().split())
    #유효하지 않은 표현일 경우의 -1을 초기값 설정
    result = -1
    #min(x에 M을 계속 더한 값 = y에 N을 계속 더한 값)일 때 정답 => 둘다 N으로 나눴을떄 나머지가 같으면 정답
    #M, N, x, y = 10, 12, 3, 9이면
    #x => 3 13 23 33....
    #y => 9 21 33 45....이므로 정답은 33이다.
    while x <= M * N: #이 범위를 넘으면 유효하지 않은 표현
        if (x-y)%N==0: #x와 y를 둘다 N으로 나눴을떄 나머지가 같으면 정답
            result = x
            break
        x += M
    print(result)