import sys
import heapq

INF = int(1e9)

N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(N+1)]
#그래프 간선과 거리 입력
for _ in range(M):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a].append((b,c))
start, end = map(int, sys.stdin.readline().split())

#그래프의 최소 거리는 다익스트라
def dijkstra(start):
    Distance = [INF for  _ in range(N+1)] #각 노드의 최소 거리 초기화
    q = []
    heapq.heappush(q,(0,start)) #출발 노드로부터 가장 거리가 짧은 노드를 빨리 찾기 위해 사용
    Distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if Distance[now] < dist: #현재 노드의 최소거리가 지금 현재 간선 거리보다 짧다면
            continue #뭘 더해도 최소가 아니므로 다음 노드로 넘어간다.
        for g in graph[now]: #현재노드~다음노드
            cost = dist+g[1]
            if Distance[g[0]] > cost: #최솟값 갱신
                Distance[g[0]] = cost
                heapq.heappush(q,(cost,g[0]))
    return Distance

print(dijkstra(start)[end])