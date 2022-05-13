import sys
import heapq
INF = int(1e9)
V, E = map(int,sys.stdin.readline().split())
K = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(V+1)]
Distance = [INF] * (V+1)
for _ in range(E):
    u, v, w = map(int,sys.stdin.readline().split())
    graph[u].append((v,w))

def dijkstra(start):
    q = []
    heapq.heappush(q,(0,start))
    Distance[start] = 0
    while q:
        dist,now = heapq.heappop(q)
        if Distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist+i[1]
            if cost < Distance[i[0]]:
                heapq.heappush(q,(cost,i[0]))
                Distance[i[0]]=cost

dijkstra(K)

for i in range(1,V+1):
    if Distance[i]==INF:
        print("INF")
    else:
        print(Distance[i])