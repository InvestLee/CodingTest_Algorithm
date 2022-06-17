#BFS도 가능하지만 다익스트라 사용
import sys
import heapq

INF = int(1e9)
N, M = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]

#노드간 가중치는 1
for _ in range(M):
    A, B = map(int, sys.stdin.readline().split())
    graph[B].append([A,1])
    graph[A].append([B,1])

def dijkstra(start):
    Distance = [INF for _ in range(N+1)]
    q = []
    heapq.heappush(q,(start,0))
    Distance[start] = 0
    while q:
        now, dist = heapq.heappop(q)
        if Distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < Distance[i[0]]:
                Distance[i[0]] = cost
                heapq.heappush(q,(i[0],cost))
    return Distance

#케빈 베이컨 최소값 설정
min_kebin = INF
result = 0
for i in range(1,N+1):
    sum_dijkstra = sum(dijkstra(i))-dijkstra(i)[0]
    if min_kebin > sum_dijkstra:
        min_kebin = sum_dijkstra
        result = i
print(result)