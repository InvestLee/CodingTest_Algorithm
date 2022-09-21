import heapq

def solution(n, s, a, b, fares):
    #다익스트라를 사용하기 위한 그래프 setting
    graph = [[] for _ in range(n+1)]
    for i, j, k in fares:
        graph[i].append([j,k])
        graph[j].append([i,k])
    
    #출발점에서 각 노드까지의 최단거리(다 익스트라) 
    def dijkstra(start):
        Distance = [int(1e9)] * (n+1)
        q = []
        heapq.heappush(q,(0,start))
        Distance[start] = 0
        while q:
            dist, now = heapq.heappop(q)
            if Distance[now] < dist:
                continue
            for g in graph[now]:
                cost = dist+g[1]
                if Distance[g[0]] > cost:
                    Distance[g[0]] = cost
                    heapq.heappush(q,(cost,g[0]))
        return Distance
    
    #각 경유지의 합승거리+a거리+b거리를 리스트화한 후 최솟값 리턴
    result = []
    for i in range(1,n+1):
        result.append(dijkstra(s)[i]+dijkstra(i)[a]+dijkstra(i)[b])
    
    return min(result)