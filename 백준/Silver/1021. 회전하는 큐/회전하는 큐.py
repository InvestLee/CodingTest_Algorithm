import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
pop_num = list(map(int, sys.stdin.readline().split()))
q = deque(i+1 for i in range(N))
result = 0
for p in pop_num:
    #뽑아낼 숫자가 오른쪽으로 회전 시키는 경우가 짧은 경우
    if q.index(p) > len(q) - q.index(p):
        result += len(q) - q.index(p)
        for _ in range(len(q) - q.index(p)):
            q.rotate()
        q.popleft()
    #뽑아낼 숫자가 왼쪽으로 회전 시키는 경우가 짧은 경우
    else:
        result += q.index(p)
        for _ in range(q.index(p)):
            q.rotate(-1)
        q.popleft()
print(result)