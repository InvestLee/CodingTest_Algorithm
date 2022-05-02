import sys
import heapq
#2차원 힙으로 절댓값 해결(key=절댓값, element=정수)

N = int(sys.stdin.readline().rstrip())
absol = []
for _ in range(N):
    x = int(sys.stdin.readline().rstrip())
    if x != 0:
        heapq.heappush(absol,(abs(x),x))
    else:
        if len(absol) == 0:
            print(0)
        else:
            print(heapq.heappop(absol)[1])