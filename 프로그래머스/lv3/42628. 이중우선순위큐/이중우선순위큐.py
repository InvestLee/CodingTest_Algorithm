import heapq

def solution(operations):
    #명령어와 숫자 분리
    for i in range(len(operations)):
        operations[i] = operations[i].split()
        operations[i][1] = int(operations[i][1])
    
    min_heap = []
    max_heap = []
    visited = [False] * len(operations) #각 힙 일치시키기 위한 방문 처리
    
    for i, o in enumerate(operations):
        if o[0] == 'I':
            heapq.heappush(min_heap,(o[1],i)) #최소힙
            heapq.heappush(max_heap,(-o[1],i)) #최대힙
            visited[i] = True
        else:
            if o[1] == 1:
                #최대힙이 안비어있으면서 최대힙에 해당하는 값이 이미 최소힙에 의해 삭제되어 있는 경우
                #일치될때까지 삭제
                while max_heap and not visited[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                if max_heap:
                    visited[max_heap[0][1]] = False
                    heapq.heappop(max_heap)
            else:
                while min_heap and not visited[min_heap[0][1]]:
                    heapq.heappop(min_heap)
                if min_heap:
                    visited[min_heap[0][1]] = False
                    heapq.heappop(min_heap)
    
    #작업 완료 후 일치화 작업
    while max_heap and not visited[max_heap[0][1]]:
        heapq.heappop(max_heap)
    while min_heap and not visited[min_heap[0][1]]:
        heapq.heappop(min_heap)
        
    if len(max_heap) == 0:
        return [0,0]
    else:
        return [-max_heap[0][0],min_heap[0][0]]