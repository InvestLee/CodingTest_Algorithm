import sys

N = int(sys.stdin.readline().rstrip()) #번호 입력
T = 0 #대각선 줄의 끝 번호 초기값
i = 1 #대각선 줄번호
while True:
    T += i #대각선 줄의 끝번호 계산
    if N <= T: #번호가 대각선 줄 끝번호보다 처음으로 작을때
        if i%2 == 0: #대각선 줄 짝수여부 : 방향 지정
            print("%d/%d"%((i+N-T),(T-N+1)))
            break
        else:
            print("%d/%d"%((T-N+1),(i+N-T)))
            break
    i += 1