def solution(n, s, a, b, fares):
    #플로이드 워셜 알고리즘 그래프
    graph = [[int(1e9)]*n for _ in range(n)]
    for i in range(n):
        graph[i][i] = 0
    for i,j,k in fares:
        graph[i-1][j-1] = k
        graph[j-1][i-1] = k    
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if graph[i][j] > graph[i][k]+graph[k][j]:
                    graph[i][j] = graph[i][k]+graph[k][j]
    
    #각 경유지의 합승거리+a거리+b거리 최솟값 리턴
    result = int(1e9)
    for i in range(n):
        result = min(result,graph[s-1][i]+graph[i][a-1]+graph[i][b-1])
    
    return result

'''
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
'''