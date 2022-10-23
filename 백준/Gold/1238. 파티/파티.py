import sys

import heapq

N, M, X = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):

    a, b, T = map(int, sys.stdin.readline().split())

    graph[a].append((b,T))

#다익스트라 알고리즘

def dijkstra(X,N):

    Distance = [int(1e9)]  * (N+1)

    q = []

    heapq.heappush(q,(0,X))

    Distance[X] = 0

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

#각 학생이 왕복하는 최단 거리 중 가장 오래걸리는 학생의 소요시간 계산

result = 0

for i in range(1,N+1):

    go_X = dijkstra(i,N) # i~X까지

    back_home = dijkstra(X,N) # X~i까지

    result = max(result, go_X[X]+back_home[i]) #왕복 시간 비교

print(result)