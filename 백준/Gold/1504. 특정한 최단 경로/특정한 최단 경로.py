import sys
import heapq

INF = int(1e9)
N, E = map(int,sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]
for _ in range(E):
    a, b, c = map(int,sys.stdin.readline().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
v1, v2 = map(int,sys.stdin.readline().split())


def dijkstra(start):
    Distance = [INF] * (N+1)
    q=[]
    heapq.heappush(q,(start,0))
    Distance[start] = 0
    while q:
        now, dist = heapq.heappop(q)
        if Distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist+i[1]
            if cost < Distance[i[0]]:
                Distance[i[0]] = cost
                heapq.heappush(q,(i[0],cost))
    return Distance

dist_1 = dijkstra(1) #1번접점에서 출발하는 각 접점 간 최소거리
dist_v1 = dijkstra(v1) #v1접점에서 출발하는 각 접점 간 최소거리
dist_v2 = dijkstra(v2) #v2접점에서 출발하는 각 접점 간 최소거리

#1->v1->v2->N과 1->v2->v1->N 중 짧은 길 선택
result = min(dist_1[v1]+dist_v1[v2]+dist_v2[N],dist_1[v2]+dist_v2[v1]+dist_v1[N])

if result >= INF:
    print(-1)
else:
    print(result)