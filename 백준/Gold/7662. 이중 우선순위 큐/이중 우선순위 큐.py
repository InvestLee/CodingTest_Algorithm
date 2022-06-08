import sys
import heapq

#최대값 최소값 둘다 제거할 수 있는 힙을 만들기 위해 각각 원소에 boorean을 이용하여 삭제된 원소인지 판별

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    k = int(sys.stdin.readline().rstrip())
    max_heap, min_heap = [], []
    visited = [False] * k
    
    for i in range(k):
        S, n = map(str, sys.stdin.readline().split())
        n = int(n)
        if S == 'I':
            heapq.heappush(min_heap,(n, i))
            heapq.heappush(max_heap,(-n, i))
            visited[i] = True #상대 힙에서 삭제되었는지 판단
        else:
            if n == 1:
                while max_heap and not visited[max_heap[0][1]]: #이미 삭제된 노드일 경우 삭제되지 않은 노드가 나올때 까지 모두 삭제
                    heapq.heappop(max_heap)
                if max_heap:
                    visited[max_heap[0][1]] = False #삭제된 노트 표시
                    heapq.heappop(max_heap)
            else:
                while min_heap and not visited[min_heap[0][1]]: #이미 삭제된 노드일 경우 삭제되지 않은 노드가 나올때 까지 모두 삭제
                    heapq.heappop(min_heap)
                if min_heap:
                    visited[min_heap[0][1]] = False #삭제된 노트 표시
                    heapq.heappop(min_heap)

    #연산 후 각 힙 일치화 작업
    while max_heap and not visited[max_heap[0][1]]:
        heapq.heappop(max_heap)
    while min_heap and not visited[min_heap[0][1]]:
        heapq.heappop(min_heap)

    if max_heap and min_heap:
        print(-max_heap[0][0],min_heap[0][0])
    else:
        print('EMPTY')
