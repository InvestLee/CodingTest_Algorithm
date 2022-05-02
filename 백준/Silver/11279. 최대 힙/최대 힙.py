import sys
import heapq

#힙의 최댓값은 디폴트인 최솟값을 뒤집은 수 즉 마이너스 부호을 붙이면 된다.

N = int(sys.stdin.readline().rstrip())
heap = []
for _ in range(N):
    x = int(sys.stdin.readline().rstrip())
    if x != 0:
        heapq.heappush(heap,-x)
    else:
        if len(heap) == 0:
            print(0)
        else:
            print(-heapq.heappop(heap))