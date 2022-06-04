import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

#bfs를 사용하여 3가지 경우(X-1,X+1,2*X)를 모두 실행

visited = [0] * (100000+1) #메모이제이션

queue = deque([(N)]) #초기위치
while queue:
    q = queue.popleft() #현재 위치
    if q == K: #현재 위기가 목표 위치라면 출력
        print(visited[q])
        break
    step = [q-1,q+1,2*q] #1초 뒤 위치
    for s in step:
        if 0 <= s <= 100000 and not visited[s]: #영역 내 탐색하지 않은 위치
            visited[s] = visited[q] + 1 #현재 위치도달 시간+1 = 1초뒤 위치 도달 시간 
            queue.append((s)) #다음 탐색