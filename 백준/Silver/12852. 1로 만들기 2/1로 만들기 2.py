import sys
from collections import deque

def make_one(N):
    if N == 1: #N이 처음부터 1인 경우
        return 0, "1"
    q = deque()
    q.append((N,0,str(N))) #현재 N, 횟수, 만드는 과정
    while q:
        n, cnt, r = q.popleft()
        if n % 3 == 0: #3으로 나누어 떨어지면 실행
            next_n = n // 3
            next_r = r+" "+str(next_n)
            if next_n == 1:
                return cnt+1, next_r
            q.append((next_n,cnt+1,next_r))
        if n % 2 == 0: #2으로 나누어 떨어지면 실행
            next_n = n // 2
            next_r = r+" "+str(next_n)
            if next_n == 1:
                return cnt+1, next_r
            q.append((next_n,cnt+1,next_r))
        next_n = n - 1
        next_r = r+" "+str(next_n)
        if next_n == 1:
            return cnt+1, next_r
        q.append((next_n,cnt+1,next_r))

N = int(sys.stdin.readline().rstrip())
result, route = make_one(N)
print(result)
print(route)