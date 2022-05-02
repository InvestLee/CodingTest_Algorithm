import sys
import heapq

#힙 자체가 최소값이 roof라서 그대로 실행하면 됨

N = int(sys.stdin.readline().rstrip())
heap = []
for _ in range(N):
    x = int(sys.stdin.readline().rstrip())
    if x != 0:
        heapq.heappush(heap,x)
    else:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap))