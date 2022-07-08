import sys
from collections import deque

start, target = map(int, sys.stdin.readline().split())
count = -1 #만들 수 없는 경우 -1을 초기값
q = deque()
q.append((start,count+2)) #연산의 최솟값 초기값은 1

while q:
    now, cnt = q.popleft()
    multiplex_now = now*2
    add_one_now = now*10+1
    if multiplex_now > target and add_one_now > target:
        continue #무한루프를 방지하기 위한 장치
    if add_one_now == target or multiplex_now == target:
        count = cnt+1 #연산이 가능할 때 count에 대입 그 외는 대입하지 않음
        break
    else:
        q.append((multiplex_now,cnt+1))
        q.append((add_one_now,cnt+1))

print(count)